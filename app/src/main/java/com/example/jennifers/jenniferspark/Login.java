package com.example.jennifers.jenniferspark;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    /****************************/
    // VARIABLE DECLARATION
    /****************************/
    private EditText lpassword, lemail;
    private TextView lregister;
    private Button lsignin;
    private ProgressDialog progress;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    //--------------------------------------------------------//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
    }

    private void initialize(){
        lpassword = (EditText) findViewById(R.id.LoginPasswordField);
        lemail = (EditText) findViewById(R.id.LoginEmailField);
        lregister = (TextView) findViewById(R.id.LoginRegisterTextView);
        //Set color for lregister textview
        SpannableString content = new SpannableString("Register");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        lregister.setText(content);
        //......................//
        lsignin = (Button) findViewById(R.id.LoginBtn);
        progress = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        lregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
        lsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    private void login(){
        String email = lemail.getText().toString();
        String pass = lpassword.getText().toString();
        if(TextUtils.isEmpty(pass) || TextUtils.isEmpty(email)) {
            if(TextUtils.isEmpty(pass)){
                lpassword.setError("Please enter your password");
            }
            if(TextUtils.isEmpty(email)){
                lemail.setError("Please enter your email");
            }
        }
        else{
            if(!inputValidation(email)){
                lemail.setError("Your email is invalid. Please check again");
            }
            else {
                progress.setMessage("Signing in");
                progress.show();
                mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            if (task.getException() instanceof FirebaseAuthInvalidUserException) {
                                Toast.makeText(Login.this, "There is no user record" +
                                        "corresponding to this identifier", Toast.LENGTH_SHORT).show();
                            }
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(Login.this, "The password is invalid", Toast.LENGTH_SHORT).show();
                            }
                            progress.dismiss();
                        } else {
                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users");
                            databaseReference.addValueEventListener(new ValueEventListener() {
                               @Override
                               public void onDataChange(DataSnapshot dataSnapshot) {
                                   for(DataSnapshot datasnapshot: dataSnapshot.getChildren()){
                                       if(datasnapshot.getKey().equals(mAuth.getCurrentUser().getUid())){
                                           User user = datasnapshot.getValue(User.class);
                                           Toast.makeText(Login.this, "Signed in. Welcome "+ user.getName(), Toast.LENGTH_SHORT).show();
                                           break;
                                       }
                                   }
                               }
                               @Override
                               public void onCancelled(DatabaseError databaseError) {

                               }
                           });
                            progress.dismiss();
                            startActivity(new Intent(Login.this,Map.class));
                        }
                    }
                });
            }
        }
    }
    private boolean inputValidation(String inputText){
        boolean valid = true;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(!inputText.matches(EMAIL_PATTERN))
        {
            valid = false;
        }
        return valid;
    }
}

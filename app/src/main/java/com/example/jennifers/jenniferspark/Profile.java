package com.example.jennifers.jenniferspark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    private TextView profilename, profileemail, changename, changepass;
    private Button backbtn;
    private ClientStorage clientStorage;
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initialize();
    }

    private void initialize() {
        clientStorage = new ClientStorage(this);
        currentUser = clientStorage.getCurrentUser();
        profileemail = (TextView) findViewById(R.id.profileemailtv);
        profilename = (TextView) findViewById(R.id.profilenametv);
        changename = (TextView) findViewById(R.id.profilechangenametv);
        changepass = (TextView) findViewById(R.id.profilechangepasstv);
        backbtn = (Button) findViewById(R.id.profilebackbtn);
        profileemail.setText(currentUser.getEmail());
        profilename.setText(currentUser.getName());
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this,Map.class));
            }
        });
        changename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeName();
            }
        });
        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }
        });
    }
    private void changeName(){
        //TODO
    }
    private void changePassword(){
        //TODO
    }

}

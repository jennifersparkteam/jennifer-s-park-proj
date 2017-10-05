package com.example.jennifers.jenniferspark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddParkingLot extends AppCompatActivity {
    private EditText title, address, cost, hour;
    private Button addParkingbtn;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parking_lot);
        initilize();
    }

//***************Help Method********************//

    private void initilize() {

        //Initialize all components

        title = (EditText) findViewById(R.id.parkinglottitletv);
        address = (EditText) findViewById(R.id.parkinglotaddresstv);
        cost = (EditText) findViewById(R.id.parkinglotcosttv);
        hour = (EditText) findViewById(R.id.parkinglothourtv);
        addParkingbtn = (Button) findViewById(R.id.addparkinglotbtn);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Parkings");
        //..............................//

        // Set up listener for button
        addParkingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewParkingLot();
            }
        });
        //............................//
    }

    private void addNewParkingLot() {
        if (!validation()) {

        } else {
            String titleval = title.getText().toString();
            String addressval = address.getText().toString();
            double costval = Double.parseDouble(cost.getText().toString());
            double hourval = Double.parseDouble(hour.getText().toString());
            mDatabase.push().setValue(new Parking(titleval, addressval, costval, hourval), new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError != null) {
                        Toast.makeText(getApplicationContext(), "Data could not be saved " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Data saved successfully.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddParkingLot.this, Map.class));
                    }
                }
            });
        }
    }

    private boolean validation() {
        return true;
    }
}
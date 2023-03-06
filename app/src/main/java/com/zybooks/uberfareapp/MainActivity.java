package com.zybooks.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    //Establishing Variables
    Spinner vehicle;
    EditText mileage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning Variables
        vehicle = findViewById(R.id.spnVehiSelect);
        mileage = findViewById(R.id.edtxtMilesInput);

        //Creation of Shared Preferences
        SharedPreferences storeInfo = getSharedPreferences("uberInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = storeInfo.edit();

        //Creation of On Click to change activities and assign values to Shared Preference
        Button btnEstimate = (Button) findViewById(R.id.btnEstimate);
        btnEstimate.setOnClickListener(view -> {
            editor.putString("myVehicle", vehicle.getSelectedItem().toString());
            editor.putString("myMileage", mileage.getText().toString());
            editor.putInt("myVehicleSelect", Math.toIntExact(vehicle.getSelectedItemId()));

            editor.apply();
            startActivity(new Intent(MainActivity.this, SummaryActivity.class));
        });


    }
}
package com.zybooks.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    //Creation of Variable
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //Assigning value to variable
        results = findViewById(R.id.txtResults);

        Button btnBack = (Button) findViewById(R.id.btnBackResults);
        btnBack.setOnClickListener(view -> startActivity(new Intent(ResultsActivity.this, MainActivity.class)));

        //Retrieving Shared Preferences
        SharedPreferences getInfo = getSharedPreferences("uberInfo", MODE_PRIVATE);

        Double mileage = Double.parseDouble(getInfo.getString("myMileage", "0.0"));
        Double mpm = 0.31; //Miles per Minute found by dividing the average of US Miles per Hour driven by 60

        //Calculating arrival time based off of given info (I acknowledge what I'm using is completely arbitrary)
        int minutes = (int) Math.ceil(mileage * mpm);
        // If statement because I wanted proper grammar for 1 minute
        if (minutes == 1){
            results.setText("Your driver, Jim Bob McGee, will be arriving in about 1 minute!");
        }
        else{
            results.setText("Your driver, Jim Bob McGee, will be arriving in about " + minutes + " minutes!");
        }
    }
}
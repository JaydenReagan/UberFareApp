package com.zybooks.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SummaryActivity extends AppCompatActivity {
    //Establishing Variables
    TextView milesDisplay;
    TextView vehiDisplay;
    TextView estimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        //Assigning Variables
        milesDisplay = findViewById(R.id.txtMilesDisplay);
        vehiDisplay = findViewById(R.id.txtVehiDisplay);
        estimate = findViewById(R.id.txtEstimate);

        //On click event to return to Main Activity
        Button btnBack = (Button) findViewById(R.id.btnBackSummary);
        btnBack.setOnClickListener(view -> startActivity(new Intent(SummaryActivity.this, MainActivity.class)));

        //On click event to move on to Results Activity
        Button btnRequest = (Button) findViewById(R.id.btnRequestRide);
        btnRequest.setOnClickListener(view -> startActivity(new Intent(SummaryActivity.this, ResultsActivity.class)));

        //Retrieval of Shared Preferences
        SharedPreferences getInfo = getSharedPreferences("uberInfo", MODE_PRIVATE);

        //Getting values from Shared Preferences and setting the Text Views
        String mileage = getInfo.getString("myMileage", "");
        String vehicle = getInfo.getString("myVehicle", "");

        milesDisplay.setText("Miles: " + mileage);
        vehiDisplay.setText("Vehicle: " + vehicle);

        //Getting numerical values from Shared Preferences
        int vehicleSelected  = getInfo.getInt("myVehicleSelect", -1);
        Double calcMileage = Double.parseDouble(mileage);

        Double total = 0.0;
        Double fee = 3.0, rate = 3.25; // Set variables that can be changed if prices change
        // If statement to determine cost depending on the Vehicle selected
        if (vehicleSelected == 0){ //Smart Car
            Double scFee = 2.0; //Fee for selecting a Smart Car
            total = fee + scFee + (calcMileage * rate);
        }
        else if (vehicleSelected == 1){ //Sedan
            total = fee + (calcMileage * rate);
        }
        else if (vehicleSelected == 2){ //Mini Van
            Double mvFee = 5.0; //Fee for selecting a Mini Van
            total = fee + mvFee + (calcMileage * rate);
        }

        //Showing the Estimate to the user
        DecimalFormat df = new DecimalFormat("0.00");
        estimate.setText("Estimate: $" + df.format(total));
    }
}
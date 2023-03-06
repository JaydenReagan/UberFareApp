package com.zybooks.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Button btnBack = (Button) findViewById(R.id.btnBackResults);
        btnBack.setOnClickListener(view -> startActivity(new Intent(ResultsActivity.this, MainActivity.class)));
    }
}
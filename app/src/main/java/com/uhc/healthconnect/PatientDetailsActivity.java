package com.uhc.healthconnect;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

// UI skeleton only. Logic (loading patient, history adapter, back button) is added by the logic team.
public class PatientDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
    }
}

package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView cardAddDonor;
    CardView cardAddPatient;
    CardView cardViewDonor;
    CardView cardViewPatient;
    CardView cardSettings;
    CardView cardLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardAddDonor = findViewById(R.id.cardAdd_donor);
        cardAddPatient = findViewById(R.id.cardAdd_patient);
        cardViewDonor = findViewById(R.id.cardView_donor);
        cardViewPatient = findViewById(R.id.cardView_Patient);
        cardSettings = findViewById(R.id.cardSettings);
        cardLogout = findViewById(R.id.cardLogout);

        cardAddDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, AddDonorActivity.class);
                startActivity(intent1);
                showToast("Add Donor Clicked");
            }
        });

        cardAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, AddPatientActivity.class);
                startActivity(intent2);
                showToast("Add Patients Clicked");
            }
        });

        cardViewDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, ViewDonorActivity.class);
                startActivity(intent3);
                showToast("View Donor Clicked");
            }
        });

        cardViewPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this, ViewPatientActivity.class);
                startActivity(intent4);
                showToast("View Patient Clicked");
            }
        });




        cardSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent5);
                showToast("Settings Clicked");
            }
        });

        cardLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(MainActivity.this, logoutActivity.class);
                startActivity(intent6);
                showToast("Logout Clicked");
            }
        });



    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
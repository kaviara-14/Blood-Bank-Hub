package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddDonorActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private EditText editTextBloodGrp;
    private EditText editTextAge;
    private EditText editTextGender;
    private EditText editTextLocation;
    private EditText editTextMobile;
    private EditText editTextEmail;


    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donor);

        db = FirebaseFirestore.getInstance();

        editTextName = findViewById(R.id.donorfull_name);
        editTextBloodGrp = findViewById(R.id.donorblood_grp);
        editTextAge = findViewById(R.id.donor_age);
        editTextGender = findViewById(R.id.donor_gender);
        editTextLocation = findViewById(R.id.donor_location);
        editTextMobile = findViewById(R.id.donor_mobile);
        editTextEmail = findViewById(R.id.donor_email);


        findViewById(R.id.donor_button).setOnClickListener(this::onClick);
    }

    private boolean hasValidationErrors(String name, String blood_grp, String age, String gender, String location, String mobile, String email) {
        if (name.isEmpty()) {
            editTextName.setError("Name is required");
            editTextName.requestFocus();
            return true;
        }

        if (blood_grp.isEmpty()) {
            editTextBloodGrp.setError("Blood Group is required");
            editTextBloodGrp.requestFocus();
            return true;
        }

        if (age.isEmpty()) {
            editTextAge.setError("Age is required");
            editTextAge.requestFocus();
            return true;
        }

        if (gender.isEmpty()) {
            editTextGender.setError("Gender is required");
            editTextGender.requestFocus();
            return true;
        }

        if (location.isEmpty()) {
            editTextLocation.setError("Location is required");
            editTextLocation.requestFocus();
            return true;
        }

        if (mobile.isEmpty()) {
            editTextLocation.setError("mobile is required");
            editTextLocation.requestFocus();
            return true;
        }

        if (email.isEmpty()) {
            editTextLocation.setError("Email is required");
            editTextLocation.requestFocus();
            return true;
        }
        return false;
    }

    public void onClick(View v){
        String name = editTextName.getText().toString().trim();
        String bloodgrp = editTextBloodGrp.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();
        String gender = editTextGender.getText().toString().trim();
        String location = editTextLocation.getText().toString().trim();
        String mobile = editTextMobile.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();


        if (!hasValidationErrors(name,bloodgrp, age, gender, location, mobile, email)) {

            CollectionReference dbdonors = db.collection("Donors");

            Donors donors = new Donors(
                    name,
                    bloodgrp,
                    gender,
                    location,
                    email,
                    Long.parseLong(mobile),
                    Integer.parseInt(age)

            );

            dbdonors.add(donors)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(AddDonorActivity.this, "Donor Info Successfully Added", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddDonorActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        }
    }


}
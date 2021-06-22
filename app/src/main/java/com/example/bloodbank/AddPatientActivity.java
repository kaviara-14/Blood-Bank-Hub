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

public class AddPatientActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextBlood_Grp;
    private EditText editTextAge;
    private EditText editTextGender;
    private EditText editTextLocation;
    private EditText editTextMobile;
    private EditText editTextHospital;
    private EditText editTextEmail;


    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        db = FirebaseFirestore.getInstance();

        editTextName = findViewById(R.id.patientfull_name);
        editTextBlood_Grp = findViewById(R.id.patientbld_grp);
        editTextAge = findViewById(R.id.patient_age);
        editTextGender = findViewById(R.id.patient_gender);
        editTextLocation = findViewById(R.id.patient_location);
        editTextHospital = findViewById(R.id.patient_hospital);
        editTextMobile = findViewById(R.id.patient_mobile);
        editTextEmail = findViewById(R.id.patient_email);


        findViewById(R.id.patient_button).setOnClickListener(this::onClick);


    }

    private boolean hasValidationErrors(String name, String bloodgrp, String age, String gender, String location, String hospital, String mobile, String email) {
        if (name.isEmpty()) {
            editTextName.setError("Name is required");
            editTextName.requestFocus();
            return true;
        }

        if (bloodgrp.isEmpty()) {
            editTextBlood_Grp.setError("Blood Group is required");
            editTextBlood_Grp.requestFocus();
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

        if (hospital.isEmpty()) {
            editTextHospital.setError("Hospital is required");
            editTextHospital.requestFocus();
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
        String blood_grp = editTextBlood_Grp.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();
        String gender = editTextGender.getText().toString().trim();
        String location = editTextLocation.getText().toString().trim();
        String hospital = editTextHospital.getText().toString().trim();
        String mobile = editTextMobile.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();


        if (!hasValidationErrors(name,blood_grp, age, gender, location, mobile, email, hospital)) {

            CollectionReference dbpatient = db.collection("Patients");

            Patients patient = new Patients(
                    name,
                    blood_grp,
                    gender,
                    email,
                    hospital,
                    location,
                    Long.parseLong(mobile),
                    Integer.parseInt(age)

            );

            dbpatient.add(patient)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(AddPatientActivity.this, "Patient Info Successfully Added", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddPatientActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        }
    }

}
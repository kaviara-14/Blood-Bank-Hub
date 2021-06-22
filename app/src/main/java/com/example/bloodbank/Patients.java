package com.example.bloodbank;

import com.google.firebase.firestore.Exclude;

public class Patients {


    private String name, blood_grp, gender, email, location, hospital;
    private long mobile;
    private int age;

    public Patients() {

    }


    public Patients(String name, String blood_grp, String gender, String email, String hospital,
                    String location, long mobile, int age) {
        this.name = name;
        this.blood_grp = blood_grp;
        this.gender = gender;
        this.email = email;
        this.hospital = hospital;
        this.location = location;
        this.mobile = mobile;
        this.age = age;


    }

    public String getName() {
        return name;
    }


    public String getBlood_grp() {
        return blood_grp;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getHospital() {
        return hospital;
    }

    public String getLocation() {
        return location;
    }


    public long getMobile() {
        return mobile;
    }

    public int getAge() {
        return age;
    }
}



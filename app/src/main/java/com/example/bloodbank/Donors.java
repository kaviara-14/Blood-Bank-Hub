package com.example.bloodbank;

import com.google.firebase.firestore.Exclude;

public class Donors {

    private String name, blood_grp, gender, location, email;
    private long mobile;
    private int age;

    public Donors() {

    }


    public Donors(String name, String blood_grp, String gender, String location, String email, long mobile, int age) {
        this.name = name;
        this.blood_grp = blood_grp;
        this.gender = gender;
        this.location = location;
        this.email = email;
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

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public long getMobile() {
        return mobile;
    }

    public int getAge() {
        return age;
    }
}

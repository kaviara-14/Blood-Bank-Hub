package com.example.bloodbank;

public class PatientUsers {

    String name,hospital,location,blood_grp;
    long mobile;

    public PatientUsers(){

    }

    public PatientUsers(String name, String hospital, String location, String blood_grp, long mobile) {
        this.name = name;
        this.hospital = hospital;
        this.location = location;
        this.blood_grp = blood_grp;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBlood_grp() {
        return blood_grp;
    }

    public void setBlood_grp(String blood_grp) {
        this.blood_grp = blood_grp;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
}

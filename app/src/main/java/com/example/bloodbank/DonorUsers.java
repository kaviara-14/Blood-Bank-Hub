package com.example.bloodbank;

public class DonorUsers {

    String name,location,email,blood_grp;
    long mobile;

    public DonorUsers() {

    }

    public DonorUsers(String name, String location, String email, String blood_grp, long mobile) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.blood_grp = blood_grp;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

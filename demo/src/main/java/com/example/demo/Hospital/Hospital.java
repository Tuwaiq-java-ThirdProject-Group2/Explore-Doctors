package com.example.demo.Hospital;

import javax.persistence.*;

@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private long hospitalId;
private String name;
private String email ;
private int phone ;
private String Address;
private double langtiude;
private double lattiude;

public Hospital(){}
    public Hospital(long hospitalId, String name, String email, int phone, String address, double langtiude, double lattiude) {
        this.hospitalId = hospitalId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        Address = address;
        this.langtiude = langtiude;
        this.lattiude = lattiude;
    }

    public long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getLangtiude() {
        return langtiude;
    }

    public void setLangtiude(double langtiude) {
        this.langtiude = langtiude;
    }

    public double getLattiude() {
        return lattiude;
    }

    public void setLattiude(double lattiude) {
        this.lattiude = lattiude;
    }
}

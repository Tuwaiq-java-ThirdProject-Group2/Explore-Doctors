package com.example.demo.Doctor;

import com.example.demo.Contract.Contract;
import com.example.demo.Evaluation.Evaluation;
import com.example.demo.Section.Section;
import com.example.demo.Specialties.Specialties;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doctor")
@SequenceGenerator(name = "DocSeq", initialValue = 1, allocationSize = 100)
public class Doctor {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DocSeq")
    private long DoctorId;
    private String name;
    private double total_rate;
    private boolean approved;
    private String certificate_name;
    private String certificate_img;
    private Date certificate_date;
    // CascadeType.ALL variable
    // target = table contain forigen key
    @JsonIgnore
    @OneToMany()
    public List<Evaluation> e;
    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = true
    )
    @JoinColumn(
            name = "sectionId"
    )
    private Section sectionId;

    @OneToOne(//cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = true
    )
    @JoinColumn(
            name = "contractId"
    )
    private Contract contractId;

    @OneToOne(
            fetch = FetchType.EAGER,
            optional = true
    )
    @JoinColumn(
            name = "specialtyId"
    )
    private Specialties specialties;


    public Doctor() {

    }

    public Doctor(Long doctorId, String name, double total_rate, boolean approved,
                  String certificate_name, String certificate_img, Date certificate_date,
                  List<Evaluation> e, Section sectionId, Contract contractId, Specialties specialties) {
        DoctorId = doctorId;
        this.name = name;
        this.total_rate = total_rate;
        this.approved = approved;
        this.certificate_name = certificate_name;
        this.certificate_img = certificate_img;
        this.certificate_date = certificate_date;
       this.e=e;
        this.sectionId = sectionId;
        this.contractId = contractId;
        this.specialties = specialties;
    }


    public long getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(long doctorId) {
        this.DoctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal_rate() {
        return total_rate;
    }

    public void setTotal_rate(double total_rate) {
        this.total_rate = total_rate;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getCertificate_name() {
        return certificate_name;
    }

    public void setCertificate_name(String certificate_name) {
        this.certificate_name = certificate_name;
    }

    public String getCertificate_img() {
        return certificate_img;
    }

    public void setCertificate_img(String certificate_img) {
        this.certificate_img = certificate_img;
    }

    public Date getCertificate_date() {
        return certificate_date;
    }

    public void setCertificate_date(Date certificate_date) {
        this.certificate_date = certificate_date;
    }

    public List<Evaluation> getE() {
        return e;
    }

    public void setE(List<Evaluation> e) {
        this.e = e;
    }

    public void setSectionId(Section sectionId) {
        this.sectionId = sectionId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public void setSpecialties(Specialties specialties) {
        this.specialties = specialties;
    }


    public Section getSectionId() {
        return sectionId;
    }

    public Contract getContractId() {
        return contractId;
    }

    public Specialties getSpecialties() {
        return specialties;
    }
}



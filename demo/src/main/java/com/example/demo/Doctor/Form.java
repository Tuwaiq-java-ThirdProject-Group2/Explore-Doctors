package com.example.demo.Doctor;

public class Form {
    private Doctor doctor;
   // private Long specialtyId;
    private Long sectionId;
   // private Long contractId;


    public Form(Doctor doctor, Long specialtyId, Long sectionId, Long contractId) {
        this.doctor = doctor;
     //   this.specialtyId = specialtyId;
        this.sectionId = sectionId;
        //this.contractId = contractId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

//    public Long getSpecialtyId() {
//        return specialtyId;
//    }

    public Long getSectionId() {
        return sectionId;
    }

//    public Long getContractId() {
//        return contractId;
//    }


}

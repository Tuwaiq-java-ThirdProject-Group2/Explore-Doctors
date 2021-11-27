package com.example.demo.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServies {


    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServies(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getAprovedDoctors(Boolean status) {
        return doctorRepository.getAllByApproved(status);
    }

    public Doctor getDoctor(String id) {
        Long doctor_id = Long.parseLong(id);
        return doctorRepository.findById(doctor_id).orElse(null);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(String id) {
        Long doctor_id = Long.parseLong(id);
        doctorRepository.deleteById(doctor_id);
    }

    public void updateDoctor(String id, Doctor data) {
        Long doctor_id = Long.parseLong(id);
        Doctor doctor = doctorRepository.findById(doctor_id).orElse(null);
        if (doctor != null) {
            doctor.setName(data.getName());
            doctor.setTotal_rate(data.getTotal_rate());
            doctor.setApproved(data.isApproved());
            doctor.setCertificate_name(data.getCertificate_name());
            doctor.setCertificate_img(data.getCertificate_img());
            doctor.setCertificate_date(data.getCertificate_date());


        }
    }


}


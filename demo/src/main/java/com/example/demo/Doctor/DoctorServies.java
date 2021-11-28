package com.example.demo.Doctor;

import com.example.demo.Section.Section;
import com.example.demo.Section.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServies {


    private final DoctorRepository doctorRepository;
    private final SectionRepository sectionRepository;

    @Autowired
    public DoctorServies(DoctorRepository doctorRepository, SectionRepository sectionRepository) {
        this.doctorRepository = doctorRepository;
        this.sectionRepository = sectionRepository;
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

    public Doctor createDoctor(Doctor doctor, Long sectionId) {
        Section section = (Section) sectionRepository.findById(sectionId).orElse(null);
        doctor.setSectionId(section);
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


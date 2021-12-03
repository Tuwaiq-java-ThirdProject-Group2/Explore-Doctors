package com.example.demo.Doctor;

import com.example.demo.Contract.Contract;
import com.example.demo.Contract.ContractRepository;
import com.example.demo.Evaluation.Evaluation;
import com.example.demo.Evaluation.EvaluationRepository;
import com.example.demo.Section.Section;
import com.example.demo.Section.SectionRepository;
import com.example.demo.Specialties.Specialties;
import com.example.demo.Specialties.SpecialtiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServies {


    private final DoctorRepository doctorRepository;
    private final SectionRepository sectionRepository;
    private final SpecialtiesRepository specialtiesRepository;
    private final ContractRepository contractRepository;
    private final EvaluationRepository evaluationRepository;

    @Autowired
    public DoctorServies(DoctorRepository doctorRepository, SectionRepository sectionRepository, SpecialtiesRepository specialtiesRepository, ContractRepository contractRepository, EvaluationRepository evaluationRepository) {
        this.doctorRepository = doctorRepository;
        this.sectionRepository = sectionRepository;
        this.specialtiesRepository=specialtiesRepository;
        this.contractRepository = contractRepository;
        this.evaluationRepository = evaluationRepository;
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

    public Doctor createDoctor(Doctor doctor, Long sectionId, Long specialtyId, Long contractId) {
        Section section = (Section) sectionRepository.findById(sectionId).orElse(null);
        doctor.setSectionId(section);
        Specialties Specialties = (Specialties)specialtiesRepository.findById(specialtyId).orElse(null);
        System.out.println(Specialties.getSpecialtiesId());
        doctor.setSpecialties(Specialties);
        Contract contract= (Contract) contractRepository.findById(contractId).orElse(null);
        doctor.setContractId(contract);

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
//    Change doctor status to true
    public void updateApprovedDoctor(String id,Boolean b){
        System.out.println(b);
        Long doctor_id = Long.parseLong(id);
        Doctor doctor = doctorRepository.findById(doctor_id).orElse(null);
        if (doctor != null) {
            System.out.println(b);
            doctor.setApproved(b);
            System.out.println(doctor.isApproved());
            doctorRepository.save(doctor);


        }
    }

}


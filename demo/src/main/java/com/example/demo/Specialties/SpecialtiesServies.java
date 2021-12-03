package com.example.demo.Specialties;

import com.example.demo.Doctor.Doctor;
import com.example.demo.Doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SpecialtiesServies {
    private final SpecialtiesRepository specialtiesRepository;
    private final DoctorRepository doctorRepository;
    @Autowired
    public SpecialtiesServies(SpecialtiesRepository specialtiesRepository, DoctorRepository doctorRepository){this.specialtiesRepository=specialtiesRepository;
        this.doctorRepository = doctorRepository;
    }
    public List<Specialties> getSpecialtiess(){
        return specialtiesRepository.findAll();
    }

    public Specialties getSpecialties(String id){
        Long Specialties_id=Long.parseLong(id);
        return specialtiesRepository.findById(Specialties_id).orElse(null);
    }

    public Specialties createSpecialties(Specialties specialties){
        return specialtiesRepository.save(specialties);
    }

    public void deleteSpecialties(String id){
        Long Specialties_id = Long.parseLong(id);
        specialtiesRepository.deleteById(Specialties_id);
    }

    public void updateSpecialties(String id, Specialties data){
        Long Specialties_id = Long.parseLong(id);
        Specialties specialties = specialtiesRepository.findById(Specialties_id).orElse(null);

        if (specialties != null) {
            specialties.setSpecialtyName(data.getSpecialtyName());
            specialties.setSpecialtyCode(data.getSpecialtyCode());
            specialtiesRepository.save(specialties);
        }
    }
    public List<Doctor> findDoctorBySpecialties(String Specialties){
        List<Doctor> doctorList = doctorRepository.getAllByApproved(true);
        List<Doctor> doctorListBySpecialties = new ArrayList<>();
        for(Doctor t:doctorList){
            System.out.println(t.getSpecialties().getSpecialtyName());
            System.out.println(Specialties);

            if(t.getSpecialties()!=null){
                System.out.println(t.getSpecialties().getSpecialtyName());
                if( t.getSpecialties().getSpecialtyName().equalsIgnoreCase("Specialties")){
                    doctorListBySpecialties.add(t);
                }
            }

        }
        return doctorListBySpecialties;
    }
}

package com.example.demo.Specialties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SpecialtiesServies {
    private final SpecialtiesRepository specialtiesRepository;
    @Autowired
    public SpecialtiesServies(SpecialtiesRepository specialtiesRepository){this.specialtiesRepository=specialtiesRepository;}
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
}

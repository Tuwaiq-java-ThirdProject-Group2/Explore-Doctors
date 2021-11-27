package com.example.demo.Section;

import com.example.demo.Hospital.Hospital;
import com.example.demo.Hospital.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServies {
    private final SectionRepository sectionRepository;
    private final HospitalRepository hospitalRepository;

    @Autowired

    public SectionServies(SectionRepository sectionRepository, HospitalRepository hospitalRepository) {
        this.sectionRepository = sectionRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public List<Section> getSections() {
        return sectionRepository.findAll();
    }

    public Section getSection(String id) {
        Long section_id = Long.parseLong(id);
        return sectionRepository.findById(section_id).orElse(null);
    }

    public Section createSection(Section section, Long id) {
        Hospital hospital = (Hospital) this.hospitalRepository.findById(id).orElse(null);
        System.out.println(hospital);
        section.setHospital(hospital);
        return (Section) this.sectionRepository.save(section);
    }

    public void deleteService(String id) {
        Long section_id = Long.parseLong(id);
        sectionRepository.deleteById(section_id);
    }

    public void deleteAllService() {
        sectionRepository.deleteAll();
    }

    public void updateSection(String id, Section data) {
        Long section_id = Long.parseLong(id);
        Section section = sectionRepository.findById(section_id).orElse(null);


        if (section != null) {
            section.setName(data.getName());
            sectionRepository.save(section);
        }
    }
}

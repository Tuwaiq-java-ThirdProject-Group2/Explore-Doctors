package com.example.demo.Hospital;

import com.example.demo.Evaluation.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalServies {
    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalServies(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }

    public Hospital getHospital(String id) {
        Long hospital_id = Long.parseLong(id);
        return hospitalRepository.findById(hospital_id).orElse(null);
    }

    public Hospital createHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public void deleteHospital(String id) {
        Long hospital_id = Long.parseLong(id);
        hospitalRepository.deleteById(hospital_id);
    }
    public void deleteAllHospital() {
        hospitalRepository.deleteAll();
    }

    public void updateHospital(String id, Hospital data) {
        Long hospital_id = Long.parseLong(id);
        Hospital hospital = hospitalRepository.findById(hospital_id).orElse(null);

        if (hospital != null) {
            hospital.setName(data.getName());
            hospital.setEmail(data.getEmail());
            hospital.setPhone(data.getPhone());
            hospital.setAddress(data.getAddress());
            hospital.setLangtiude(data.getLangtiude());
            hospital.setLattiude(data.getLattiude());


        }
    }
    public List<Double> getLanLat(String id){
        List<Double> location = new ArrayList<>();
        Long hospital_id = Long.parseLong(id);
        Hospital h = hospitalRepository.findById(hospital_id).orElse(null);
        location.add(h.getLangtiude());
        location.add(h.getLattiude());
        System.out.println(h.getLangtiude());
        return location;
    }
}

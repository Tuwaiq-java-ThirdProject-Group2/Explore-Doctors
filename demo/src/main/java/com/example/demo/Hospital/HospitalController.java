package com.example.demo.Hospital;

import com.example.demo.Evaluation.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "hospital")
@CrossOrigin("*")
public class HospitalController {
    private final HospitalServies hospitalServies;

    @Autowired
    public HospitalController(HospitalServies hospitalServies) {
        this.hospitalServies = hospitalServies;
    }

    @GetMapping
    private List<Hospital> gitHospitals() {
        return hospitalServies.getHospitals();
    }

    @GetMapping("/{id}")
    public Hospital getHospital(@PathVariable String id) {
        return hospitalServies.getHospital(id);

    }

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital hospital) {
        return hospitalServies.createHospital(hospital);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHospital(@PathVariable String id) {
        hospitalServies.deleteHospital(id);

    }
    @DeleteMapping("/deleteAll")
    public void deleteAllHospital() {
        hospitalServies.deleteAllHospital();

    }

    @PutMapping("/{id}")
    public void updateHospital(@PathVariable String id, @RequestBody Hospital data) {
        hospitalServies.updateHospital(id, data);
    }

    @GetMapping("/location/{id}")
    public void getLanLat(@PathVariable String id) {
        hospitalServies.getLanLat(id);
    }
}



package com.example.demo.Doctor;
import com.example.demo.Evaluation.Evaluation;
import com.example.demo.Evaluation.EvaluationController;
import com.example.demo.Evaluation.EvaluationServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "doctor")
@CrossOrigin("*")
public class DoctorController {

    private final DoctorServies doctorServies;

    @Autowired
    public DoctorController(DoctorServies doctorServies) {
        this.doctorServies = doctorServies;
    }

    @GetMapping("numbersOfDoctors")
    public int getNumberOfDoctor() {
        return doctorServies.getAprovedDoctors(true).size();
    }

    @GetMapping
    public List<Doctor> getDoctors() {
        return doctorServies.getDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable String id) {
        return doctorServies.getDoctor(id);

    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Form form) {
        System.out.println(form.getDoctor());
        System.out.println(form.getContractId());
        System.out.println(form.getSectionId());
        System.out.println(form.getSpecialtyId());
        return doctorServies.createDoctor(form.getDoctor(), form.getSectionId(), form.getSpecialtyId(), form.getContractId());
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable String id) {
        doctorServies.deleteDoctor(id);

    }

    @PutMapping("/{id}")
    public void updateDoctor(@PathVariable String id, @RequestBody Doctor data) {
        doctorServies.updateDoctor(id, data);
    }

    @PutMapping("/{id_doctor}/{Decision_admin}")
    public void DecisionAdmin(@PathVariable String id_doctor, @PathVariable Boolean Decision_admin) {
        if (Decision_admin == true) {
            Doctor doctor = doctorServies.getDoctor(id_doctor);
            doctor.setApproved(true);
            doctorServies.updateApprovedDoctor(id_doctor, Decision_admin);
        } else {
            doctorServies.deleteDoctor(id_doctor);
        }
    }

}




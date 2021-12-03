package com.example.demo.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "doctor")
public class DoctorController {

    private final DoctorServies doctorServies;

    @Autowired

    public DoctorController(DoctorServies doctorServies) {
        this.doctorServies = doctorServies;
    }


    @GetMapping
        public List<Doctor> getDoctors ()
        {
            return doctorServies.getDoctors ();
        }

        @GetMapping("/{id}")
        public Doctor getDoctor(@PathVariable String id){
            return doctorServies.getDoctor(id);

        }
        @PostMapping
        public  Doctor createDoctor(@RequestBody Form form){
            return doctorServies.createDoctor(form.getDoctor(),form.getSpecialtyId(),form.getSectionId(), form.getContractId());
        }
        @DeleteMapping("/{id}")
        public void deleteDoctor(@PathVariable String id){
            doctorServies.deleteDoctor(id);

        }
        @PutMapping("/{id}")
        public void updateDoctor(@PathVariable String id, @RequestBody Doctor data)
        {
            doctorServies. updateDoctor(id,data);
        }

    }




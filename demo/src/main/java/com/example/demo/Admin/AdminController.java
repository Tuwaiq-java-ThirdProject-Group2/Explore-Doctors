package com.example.demo.Admin;


import com.example.demo.Evaluation.Evaluation;
import com.example.demo.Evaluation.EvaluationServies;
import com.example.demo.Doctor.Doctor;
import com.example.demo.Doctor.DoctorServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path = "admin")
@CrossOrigin("*")

public class AdminController {

    private final AdminServies adminServies;
    private EvaluationServies evaluationservices;
    private DoctorServies doctorServies;
    private Doctor doctor;
    private Evaluation evaluation;

    @Autowired
    public AdminController(AdminServies adminServies) {
        this.adminServies = adminServies;
    }

    @GetMapping
    private List<Admin> getAdmins() {
        return adminServies.getAdmins();
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable String id) {
        return adminServies.getAdmin(id);

    }

    @PostMapping(path = "/createAdmin")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminServies.createAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable String id) {
        adminServies.deleteAdmin(id);

    }

    @PutMapping("/{id}")
    public void updateAdmin(@PathVariable String id, @RequestBody Admin data) {
        adminServies.updateAdmin(id, data);
    }

//    @GetMapping("/{id_evaluation}/{Decision_comment}")
//    public void DecisionComment(@PathVariable String Decision_comment, @PathVariable String id_evaluation) {
//        if (Decision_comment=="true") {
//            evaluation = evaluationservices.getEvaluaiton(id_evaluation);
//            evaluation.setAproved(true);
//
//           doctorServies.getDoctor(String.valueOf(evaluation.getDoct().getDoctorId())).setTotal_rate(evaluation.getRate() + evaluation.getDoct().getTotal_rate());
//
//            evaluationservices.updateEvaluation(id_evaluation, evaluation);
//        } else {
//
//            evaluationservices.deleteEvaluation(id_evaluation);
//        }
//
//    }

//    public void updateApprovedDoctor(String id,Boolean b){
//        System.out.println(b);
//        Long doctor_id = Long.parseLong(id);
//        Doctor doctor = doctorRepository.findById(doctor_id).orElse(null);
//        if (doctor != null) {
//            System.out.println(b);
//            doctor.setApproved(b);
//            System.out.println(doctor.isApproved());
//            doctorRepository.save(doctor);
//
//
//        }
//    }

//    @PutMapping("/{id_doctor}/{Decision_admin}")
//    public void DecisionAdmin(@PathVariable String id_doctor, @PathVariable Boolean Decision_admin) {
//        if (Decision_admin == true) {
////            Doctor doctor = doctorServies.getDoctor(id_doctor);
////            doctor.setApproved(true);
//            doctorServies.updateApprovedDoctor(id_doctor, Decision_admin);
////        }else{
//////            doctorServies.deleteDoctor(id_doctor);
////        }
//        }
//    }
    @GetMapping("/BestDoctor")
    public void BestDoctor(){
        List<Doctor> doctorList=doctorServies.getAprovedDoctors(true);
        int DoctorNumber=doctorList.size();
        double maxrate=0;
       Doctor bestdoctor=null;
        for (Doctor d:doctorList) {
            if (maxrate<d.getTotal_rate()){
                maxrate=d.getTotal_rate();
                bestdoctor=d;
            }
        }
    }


}

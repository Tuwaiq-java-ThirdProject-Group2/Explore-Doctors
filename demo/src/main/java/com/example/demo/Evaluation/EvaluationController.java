package com.example.demo.Evaluation;


import com.example.demo.Doctor.Doctor;
import com.example.demo.Doctor.DoctorServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "evaluation")
@CrossOrigin("*")
public class EvaluationController {
    private final EvaluationServies evaluationServies;
    private DoctorServies doctorServies;
    private Doctor doctor;

    @Autowired
    public EvaluationController(EvaluationServies evaluationServies) {
        this.evaluationServies = evaluationServies;
    }

    @GetMapping

    private List<Evaluation> gitEvaluaitons ()
    {
        return evaluationServies.getEvaluaitons ();
    }

    @GetMapping("/{id}")
    public Evaluation gitEvaluaiton(@PathVariable String id) {
        return evaluationServies.getEvaluaiton(id);

    }
    @GetMapping("AllComment/{id}")
    public List<String> getAllCommentByDocID(@PathVariable String id) {
        return evaluationServies.getAllCommentBtDocId(id);

    }

    @GetMapping("AllRate/{id}")
    public List<Integer> getAllRateByDocID(@PathVariable String id) {
        return evaluationServies.getAllRateByDocID(id);

    }

    @PostMapping
    public Evaluation createEvaluation(@RequestBody Form form){
        return evaluationServies. createEvaluation(form.getEvaluation(),form.getDoctorId(),form.getUserId());
    }
    @DeleteMapping("/{id}")
    public void deleteEvaluation(@PathVariable String id) {
        evaluationServies.deleteEvaluation(id);
    }
    @DeleteMapping("delete/deleteAll")
    public void deleteAllEvaluation() {
        evaluationServies.deleteAllEvaluation();
    }

    @PutMapping("/{id}")
    public void updateEvaluation(@PathVariable String id, @RequestBody Evaluation data) {
        evaluationServies.updateEvaluation(id, data);
    }

    @PutMapping("/{id_evaluation}/{Decision_comment}")
    public void DecisionComment(@PathVariable Boolean Decision_comment, @PathVariable String id_evaluation) {
        if (Decision_comment == true) {
            Evaluation evaluation = evaluationServies.getEvaluaiton(id_evaluation);
            evaluation.setAproved(true);
//            doctorServies.getDoctor(String.valueOf(evaluation.getDoct().getDoctorId())).setTotal_rate(evaluation.getRate() + evaluation.getDoct().getTotal_rate());
            evaluationServies.updateAprrovedEvaluation(id_evaluation, Decision_comment);
        } else {

            evaluationServies.deleteEvaluation(id_evaluation);
        }

    }


}



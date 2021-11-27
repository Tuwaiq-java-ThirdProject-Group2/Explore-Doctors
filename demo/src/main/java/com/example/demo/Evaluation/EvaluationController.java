package com.example.demo.Evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "evaluation")

public class EvaluationController {
    private final EvaluationServies evaluationServies;

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
}



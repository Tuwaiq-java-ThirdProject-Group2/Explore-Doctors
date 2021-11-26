package com.example.demo.Evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="evaluation")
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
    public Evaluation gitEvaluaiton(@PathVariable String id){
        return evaluationServies.getEvaluaiton(id);

    }
    @PostMapping
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation){
        return evaluationServies. createEvaluation(evaluation);
    }
    @DeleteMapping("/{id}")
    public void deleteEvaluation(@PathVariable String id){
        evaluationServies.deleteEvaluation(id);

    }
    @PutMapping("/{id}")
    public void updateEvaluation(@PathVariable String id, @RequestBody Evaluation data)
    {
        evaluationServies.updateEvaluation(id,data);
    }
}



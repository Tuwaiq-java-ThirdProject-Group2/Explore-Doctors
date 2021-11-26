package com.example.demo.Evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EvaluationServies {
  private final EvaluationRepository evaluationRepository;

@Autowired
    public EvaluationServies(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public List<Evaluation> getEvaluaitons() {
    return evaluationRepository.findAll();
    }

    public Evaluation getEvaluaiton(String id) {
    Long evaluation_id= Long.parseLong(id);
    return evaluationRepository.findById(evaluation_id).orElse(null);
    }

    public Evaluation createEvaluation(Evaluation evaluation) {
    return evaluationRepository.save( evaluation);
    }


    public void deleteEvaluation(String id) {
        Long evaluation_id= Long.parseLong(id);
        evaluationRepository.deleteById(evaluation_id);
    }
    public void updateEvaluation(String id, Evaluation data) {
        Long evaluation_id= Long.parseLong(id);
        Evaluation evaluation = evaluationRepository.findById(evaluation_id).orElse(null);


        if (evaluation != null) {
            evaluation.setComment(data.getComment());
            evaluation.setCategory(data.getCategory());
            evaluation.setCategory(data.getCategory());
            evaluation.setEvaluateDate(data.getEvaluateDate());
            evaluation.setRate(data.getRate());
            evaluation.setAproved(data.isAproved());
            evaluationRepository.save(evaluation);
        }
    }
}







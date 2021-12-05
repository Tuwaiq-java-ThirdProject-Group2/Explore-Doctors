package com.example.demo.Evaluation;

import com.example.demo.Doctor.Doctor;
import com.example.demo.Doctor.DoctorRepository;
import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluationServies {
    private final EvaluationRepository evaluationRepository;
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;


    @Autowired
    public EvaluationServies(EvaluationRepository evaluationRepository, DoctorRepository doctorRepository, UserRepository userRepository) {
        this.evaluationRepository = evaluationRepository;
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
    }

    public List<Evaluation> getEvaluaitons() {
        return evaluationRepository.findAll();
    }


    public Evaluation getEvaluaiton(String id) {
        Long evaluation_id = Long.parseLong(id);
        return evaluationRepository.findById(evaluation_id).orElse(null);
    }

    public Evaluation createEvaluation(Evaluation evaluation, Long docId, Long userId) {
        System.out.println(evaluation.getEvaluationId());
        System.out.println(docId);
        System.out.println(userId);
        Doctor doctor = (Doctor) this.doctorRepository.findById(docId).orElse(null);
        evaluation.setDoct(doctor);
        System.out.println(docId);

        User user = (User) this.userRepository.findById(userId).orElse(null);
        evaluation.setUser(user);
        System.out.println(user);

        return evaluationRepository.save(evaluation);
    }


    public void deleteEvaluation(String id) {
        Long evaluation_id = Long.parseLong(id);
        evaluationRepository.deleteById(evaluation_id);
    }

    public void updateEvaluation(String id, Evaluation data) {
        Long evaluation_id = Long.parseLong(id);
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

    public void deleteAllEvaluation() {
        evaluationRepository.deleteAll();
    }

    public void updateAprrovedEvaluation(String id, Boolean aprove) {

        Long evaluation_id = Long.parseLong(id);
        Evaluation evaluation = evaluationRepository.findById(evaluation_id).orElse(null);
        if (evaluation != null) {

            evaluation.setAproved(aprove);

            evaluationRepository.save(evaluation);

        }
    }

    public List<String> getAllCommentBtDocId(String id) {
        Long doct_id = Long.parseLong(id);
        List<Evaluation> evaluation = evaluationRepository.findAll();
        List<String> comment = new ArrayList<>();
        for (Evaluation temp : evaluation) {
            if (temp.getDoct() != null) {
                if (temp.getDoct().getDoctorId() == doct_id) {
                    comment.add(temp.getComment());
                }
            }
        }
        return comment;
    }


    public List<Integer> getAllRateByDocID(String id) {
        Long doct_id = Long.parseLong(id);
        List<Evaluation> evaluation = evaluationRepository.findAll();
        List<Integer> rate = new ArrayList<>();
        for (Evaluation temp : evaluation) {
            if (temp.getDoct() != null) {
                if (temp.getDoct().getDoctorId() == doct_id) {
                    rate.add((int) temp.getRate());
                }
            }
        }
        return rate;


    }


//    public List<Evaluation> getAllByRate(double rate) {
//       return evaluationRepository.getAllByRate(rate);
////    }



}




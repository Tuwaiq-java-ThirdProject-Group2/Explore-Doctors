package com.example.demo.Evaluation;

public class Form {
    private Evaluation evaluation;
    private Long userId;
    private Long doctorId;

    public Form(Evaluation evaluation, Long userId, Long doctorId) {
        this.evaluation = evaluation;
        this.userId = userId;
        this.doctorId = doctorId;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getDoctorId() {
        return doctorId;
    }
}

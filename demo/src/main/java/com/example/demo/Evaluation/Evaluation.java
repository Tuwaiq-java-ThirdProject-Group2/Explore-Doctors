package com.example.demo.Evaluation;

import com.example.demo.Doctor.Doctor;
import com.example.demo.User.User;
//import org.apache.catalina.User;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "evaluations")

public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long evaluationId;
    private String comment;
    private String category;
    private Date evaluateDate;
    private double rate;
    private boolean Aproved;
@ManyToOne(fetch = FetchType.EAGER)
//    @ManyToOne
//    @JoinColumn(name = "doctor_id")
    private Doctor doct;
    public void setDoct(Doctor doct) {
        this.doct = doct;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Doctor getDoct() {
        return doct;
    }

    public void setTch(Doctor tch) {
        this.doct = doct;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getEvaluateDate() {
        return evaluateDate;
    }

    public void setEvaluateDate(Date evaluateDate) {
        this.evaluateDate = evaluateDate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isAproved() {
        return Aproved;
    }

    public void setAproved(boolean aproved) {
        Aproved = aproved;
    }
}


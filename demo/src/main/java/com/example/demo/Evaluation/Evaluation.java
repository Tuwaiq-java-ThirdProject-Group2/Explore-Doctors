package com.example.demo.Evaluation;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "evaluations")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  evaluationId ;
    private String comment;
    private String category;
    private Date evaluateDate;
    private double rate ;
    private boolean Aproved;
    public Evaluation(){

    }
    public Evaluation(Long evaluationId, String comment, String category, Date evaluateDate, double rate, boolean aproved) {
        this.evaluationId = evaluationId;
        this.comment = comment;
        this.category = category;
        this.evaluateDate = evaluateDate;
        this.rate = rate;
        Aproved = aproved;
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

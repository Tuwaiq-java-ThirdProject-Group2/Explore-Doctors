package com.example.demo.Contract;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contract")
@SequenceGenerator(name="ConSeq", initialValue=1, allocationSize=100)
public class Contract {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ConSeq")
    private long contractId;
    private Date start_date;
    private Date end_date;
    private String owner;

    public Contract(){

    }
    public Contract(long contractId, Date start_date, Date end_date, String owner) {
        this.contractId = contractId;
        this.start_date = start_date;
        this.end_date = end_date;
        this.owner = owner;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        contractId = contractId;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "ContractId=" + contractId +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", owner='" + owner + '\'' +
                '}';
    }
}

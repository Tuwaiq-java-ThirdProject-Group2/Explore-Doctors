package com.example.demo.Doctor;


import com.example.demo.Section.Section;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
@SequenceGenerator(name="DocSeq", initialValue=1)
public class Doctor {

        @Id
        //@GeneratedValue(strategy = GenerationType.AUTO)
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DocSeq")
        private Long DoctorId;
        private String name;
        private double total_rate;
        private boolean approved;
        private String certificate_name;
        private String certificate_img;
        private Date certificate_date;
        // CascadeType.ALL
        @OneToMany(mappedBy = "doct", cascade = CascadeType.ALL, targetEntity = com.example.demo.Evaluation.Evaluation.class)

        @ManyToOne(
                fetch = FetchType.EAGER,
                optional = true
        )
        @JoinColumn(
                name = "sectionId"
        )
        private Section sectionId;

        @OneToOne( cascade = CascadeType.ALL,
               fetch = FetchType.EAGER,
                optional = true
        )
        @JoinColumn(
                name = "contractId"
        )
        private Section contractId;

        @OneToOne(
                fetch = FetchType.EAGER,
                optional = true
        )
        @JoinColumn(
                name = "specialtyId"
        )

        Set Evaluation = new HashSet();


        public long getDoctorId() {
            return DoctorId;
        }

        public void setDoctorId(long doctorId) {
            DoctorId =doctorId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getTotal_rate() {
            return total_rate;
        }

        public void setTotal_rate(double total_rate) {
            this.total_rate = total_rate;
        }

        public boolean isApproved() {
            return approved;
        }

        public void setApproved(boolean approved) {
            this.approved = approved;
        }

        public String getCertificate_name() {
            return certificate_name;
        }

        public void setCertificate_name(String certificate_name) {
            this.certificate_name = certificate_name;
        }

        public String getCertificate_img() {
            return certificate_img;
        }

        public void setCertificate_img(String certificate_img) {
            this.certificate_img = certificate_img;
        }

        public Date getCertificate_date() {
            return certificate_date;
        }

        public void setCertificate_date(Date certificate_date) {
            this.certificate_date = certificate_date;
        }
    }



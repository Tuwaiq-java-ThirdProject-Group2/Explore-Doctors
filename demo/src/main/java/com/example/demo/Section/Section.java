package com.example.demo.Section;

import com.example.demo.Hospital.Hospital;

import javax.persistence.*;

@Entity
@Table(name = "sections")
@SequenceGenerator(name="SecSeq", initialValue=1,allocationSize=100)
public class Section {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SecSeq")
    private long sectionId;
    private String name;


    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = true
    )
    @JoinColumn(
            name = "hospitalId"
    )
    private Hospital hospitalId;

    public Section() {
    }



    public Section(long sectionId, String name,Hospital hospital) {
        this.sectionId = sectionId;
        this.name = name;
        this.hospitalId = hospital;
    }

    public Hospital getHospital() {
        return hospitalId;
    }

    public void setHospital(Hospital hospital) {
        this.hospitalId = hospital;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

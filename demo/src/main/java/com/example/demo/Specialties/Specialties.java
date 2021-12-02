package com.example.demo.Specialties;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "specialties")
@SequenceGenerator(name="SpeSeq", initialValue=1, allocationSize=100)
public class Specialties {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SpeSeq")
    private long SpecialtyId;
    private String SpecialtyName;
    private String specialtyCode;

    public Specialties() {

    }

    public Specialties(long specialtiesId, String specialtyName, String specialtyCode) {
        this.SpecialtyId = specialtiesId;
        this.SpecialtyName = specialtyName;
        this.specialtyCode = specialtyCode;
    }

    public void setSpecialtiesId(long specialtiesId) {
        this.SpecialtyId = specialtiesId;
    }

    public long getSpecialtiesId() {
        return SpecialtyId;
    }

    public void setSpecialtyName(String specialtyName) {
        this.SpecialtyName = specialtyName;
    }

    public String getSpecialtyName() {
        return SpecialtyName;
    }

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public String getSpecialtyCode() {
        return specialtyCode;
    }

    @Override
    public String toString() {
        return "Specialties{" +
                "id=" + SpecialtyId +
                ", specialtyName='" + SpecialtyName + '\'' +
                ", specialtyCode='" + specialtyCode + '\'' +
                '}';
    }
}

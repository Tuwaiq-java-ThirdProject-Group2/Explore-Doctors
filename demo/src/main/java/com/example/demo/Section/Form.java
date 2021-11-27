package com.example.demo.Section;

public class Form {
private Section section;
private Long hospitalId;

    public Form(Section section, Long hospitalId) {
        this.section = section;
        this.hospitalId = hospitalId;
    }

    public Section getSection() {
        System.out.println("section: " + section);

        return this.section;
    }

    public Long getHospetalid() {
        System.out.println("hospitalId: " + hospitalId);

        return this.hospitalId;
    }
}

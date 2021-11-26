package com.example.demo.Section;

import javax.persistence.*;

@Entity
@Table(name = "sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionId;
    private String name;

    public Section() {}
    public Section(long sectionId, String name) {
        this.sectionId = sectionId;
        this.name = name;
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

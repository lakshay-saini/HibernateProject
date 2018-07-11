package com.hibernateMapping.task.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sections {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sectionID;

    private String sectionName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sections")
    private Set<Students> students = new HashSet<Students>();

    public Set<Students> getStudents() {
        return students;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }

    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public String toString() {
        return "Sections{" +
                "sectionID=" + sectionID +
                ", sectionName='" + sectionName + '\'' +
                ", students=" + students +
                '}';
    }
}

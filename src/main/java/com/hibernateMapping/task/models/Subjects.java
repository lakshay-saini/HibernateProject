package com.hibernateMapping.task.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subjectID;

    private String subjectName;

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "subjectID=" + subjectID +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}

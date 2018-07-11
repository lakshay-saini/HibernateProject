package com.hibernateMapping.task.models;

import javax.persistence.*;


@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentID;

    private int value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_ID")
    private Result result;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_ID")
    private Sections sections;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_ID")
    private Subjects subjects;

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Sections getSections() {
        return sections;
    }

    public void setSections(Sections sections) {
        this.sections = sections;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }


    public int getValue() {
        return value;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentID=" + studentID +
                ", value=" + value +
                ", result=" + result +
                ", sections=" + sections +
                ", subjects=" + subjects +
                '}';
    }
}

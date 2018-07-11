package com.hibernateMapping.task.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resultID;

    private String resultStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "result")
    private Set<Students> students = new HashSet<Students>();

    public Set<Students> getStudents() {
        return students;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultID=" + resultID +
                ", resultStatus='" + resultStatus + '\'' +
                ", students=" + students +
                '}';
    }
}

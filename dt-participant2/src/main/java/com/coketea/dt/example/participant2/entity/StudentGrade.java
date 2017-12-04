package com.coketea.dt.example.participant2.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentGrade implements Serializable {

    private Integer studentId;

    private Double score;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}

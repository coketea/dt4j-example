package com.coketea.dt.example.participant2.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Grade {

    @EmbeddedId
    private StudentGrade studentGrade;

    public StudentGrade getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(StudentGrade studentGrade) {
        this.studentGrade = studentGrade;
    }
}

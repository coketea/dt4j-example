package com.coketea.dt.example.participant2.service.impl;

import com.coketea.dt.example.participant2.entity.Grade;
import com.coketea.dt.example.participant2.entity.StudentGrade;
import com.coketea.dt.example.participant2.repository.GradeRepository;
import com.coketea.dt.example.participant2.service.GradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class GradeServiceImpl implements GradeService {

    @Resource
    private GradeRepository gradeRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveGrade(Integer studentId, Double score) {
        StudentGrade studentGrade = new StudentGrade();
        studentGrade.setStudentId(studentId);
        studentGrade.setScore(score);
        Grade grade = new Grade();
        grade.setStudentGrade(studentGrade);
        this.gradeRepository.save(grade);
    }
}

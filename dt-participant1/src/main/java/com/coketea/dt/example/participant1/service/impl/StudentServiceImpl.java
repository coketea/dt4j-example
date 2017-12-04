package com.coketea.dt.example.participant1.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.coketea.dt.example.participant1.entity.Student;
import com.coketea.dt.example.participant1.repository.StudentRepository;
import com.coketea.dt.example.participant1.service.StudentService;
import com.coketea.dt.example.participant2.dubbo.grade.GradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Reference(version = "1.0")
    private GradeService gradeService;


    @Override
    public void saveStudentAndGrade(String name, double score) {
        Student student = new Student();
        student.setName(name);
        this.studentRepository.save(student);
        this.gradeService.saveGrade(student.getId(), score);
    }
}

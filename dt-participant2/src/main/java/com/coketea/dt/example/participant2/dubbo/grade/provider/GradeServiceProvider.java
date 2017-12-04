package com.coketea.dt.example.participant2.dubbo.grade.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.coketea.dt.example.participant2.dubbo.grade.GradeService;

import javax.annotation.Resource;

@Service(version = "1.0")
public class GradeServiceProvider implements GradeService {

    @Resource
    private com.coketea.dt.example.participant2.service.GradeService gradeService;

    @Override
    public int saveGrade(Integer studentId, Double score) {
        this.gradeService.saveGrade(studentId, score);
        return 0;
    }
}

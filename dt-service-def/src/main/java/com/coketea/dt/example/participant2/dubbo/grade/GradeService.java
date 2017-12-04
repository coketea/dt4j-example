package com.coketea.dt.example.participant2.dubbo.grade;

public interface GradeService {

    /**
     * 保存学生成绩信息
     *
     * @param studentId 学生编号
     * @param score 分数
     * @return 1-成功，0-失败
     */
    int saveGrade(Integer studentId, Double score);
}

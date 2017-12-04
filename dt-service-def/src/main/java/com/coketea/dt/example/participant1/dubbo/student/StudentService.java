package com.coketea.dt.example.participant1.dubbo.student;

public interface StudentService {

    /**
     * 保存学生信息
     *
     * @param name 学生姓名
     * @return 1-成功，0-失败
     */
    int saveStuden(String name);
}
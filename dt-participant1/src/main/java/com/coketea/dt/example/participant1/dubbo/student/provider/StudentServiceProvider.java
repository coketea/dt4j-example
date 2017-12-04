package com.coketea.dt.example.participant1.dubbo.student.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.coketea.dt.example.participant1.dubbo.student.StudentService;

@Service(version = "1.0")
public class StudentServiceProvider implements StudentService {

    @Override
    public int saveStuden(String name) {
        return 0;
    }
}

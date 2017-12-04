package com.coketea.dt.example.participant1.controller;

import com.coketea.dt.example.participant1.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/")
    @ResponseBody
    String saveUserAndGrade(@RequestParam String name, @RequestParam double score) {
        this.studentService.saveStudentAndGrade(name, score);
        return "Hello World";
    }
}

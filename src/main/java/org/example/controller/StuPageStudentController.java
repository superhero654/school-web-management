package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Result;
import org.example.pojo.Score;
import org.example.pojo.Student;
import org.example.service.ScoreService;
import org.example.service.StudentService;
import org.example.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/stuStudents")
@RestController
public class StuPageStudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/getMy")
    public Result getMy(){
        log.info("学生id:{},查询学生",CurrentHolder.getCurrentId());
        Student student = studentService.getInfo(CurrentHolder.getCurrentId());
        return Result.success(student);
    }

    @GetMapping("/getScore")
    public Result getScore(){
        log.info("学生id:{},查询学生",CurrentHolder.getCurrentId());
        List<Score>score = scoreService.getInfo(CurrentHolder.getCurrentId());
        return Result.success(score);
    }
}

package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.*;
import org.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;
    //统计职工职位人数
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计职工部门人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    //统计职工性别人数
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计职工性别人数");
        List<Map<String, Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    //统计教师职位人数
    @GetMapping("/teacherTitleData")
    public Result getTeacherTitleData(){
        log.info("统计教师职位人数");
        TitleOption titleOption = reportService.getTeacherTitleData();
        return Result.success(titleOption);
    }

    //统计教师性别人数
    @GetMapping("/teacherGenderData")
    public Result getTeacherGenderData(){
        log.info("统计教师性别人数");
        List<Map<String, Object>> genderList = reportService.getTeacherGenderData();
        return Result.success(genderList);
    }

    //统计学生班级人数
    @GetMapping("/studentClazzData")
    public Result getStudentClazzData(){
        log.info("统计学生班级人数");
        ClazzOption clazzOption = reportService.getStudentClazzData();
        return Result.success(clazzOption);
    }

    //统计学生性别人数
    @GetMapping("/studentGenderData")
    public Result getStudentGenderData(){
        log.info("统计学生性别人数");
        List<Map<String, Object>> genderList = reportService.getStudentGenderData();
        return Result.success(genderList);
    }

    //统计学生排名信息
    @GetMapping("/studentRankData")
    public Result getStudentRankData(){
        log.info("统计学生排名信息");
        RankOption rankOption = reportService.getStudentRankData();
        return Result.success(rankOption);
    }

    //统计每门课程的平均分
    @GetMapping("/studentAverageData")
    public Result getStudentAverageData(){
        log.info("统计课程均分信息");
        AverageOption averageOption = reportService.getStudentAverageData();
        return Result.success(averageOption);
    }
}

package org.example.service;

import org.example.pojo.*;

import java.util.List;
import java.util.Map;

public interface ReportService {
    //统计职工职位人数
    JobOption getEmpJobData();

    //统计职工性别人数
    List<Map<String, Object>> getEmpGenderData();

    //统计教师职位人数
    TitleOption getTeacherTitleData();

    //统计教师性别人数
    List<Map<String, Object>> getTeacherGenderData();

    //统计学生班级人数
    ClazzOption getStudentClazzData();

    //统计学生性别人数
    List<Map<String, Object>> getStudentGenderData();

    //统计学生排名信息
    RankOption getStudentRankData();

    //统计每门课程的平均分
    AverageOption getStudentAverageData();
}

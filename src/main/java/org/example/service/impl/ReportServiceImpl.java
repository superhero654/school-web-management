package org.example.service.impl;

import org.example.mapper.EmpMapper;
import org.example.mapper.ScoreMapper;
import org.example.mapper.StudentMapper;
import org.example.mapper.TeacherMapper;
import org.example.pojo.*;
import org.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    //1.职工
    @Autowired
    private EmpMapper empMapper;
    @Override
    public JobOption getEmpJobData() {
        //1.调用mapper接口,获取统计数据
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        //2.组装结果，并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    //2.教师
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public TitleOption getTeacherTitleData() {
        List<Map<String, Object>> list = teacherMapper.countTeacherTitleData();

        List<Object> titleList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new TitleOption(titleList, dataList);
    }

    @Override
    public List<Map<String, Object>> getTeacherGenderData() {
        return teacherMapper.countTeacherGenderData();
    }

    //3.学生
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public ClazzOption getStudentClazzData() {
        List<Map<String, Object>> list = studentMapper.countStudentClazzData();

        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("name")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("value")).toList();

        return new ClazzOption(clazzList, dataList);
    }

    @Override
    public List<Map<String, Object>> getStudentGenderData() {
        return studentMapper.countStudentGenderData();
    }

    //4.成绩

    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public RankOption getStudentRankData() {
        List<Map<String, Object>> list = scoreMapper.countStudentRankData();

        List<Object> rankList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new RankOption(rankList, dataList);
    }

    @Override
    public AverageOption getStudentAverageData() {
        List<Map<String, Object>> list = scoreMapper.countStudentAverageData();

        List<Object> averageList = list.stream().map(dataMap -> dataMap.get("courseName")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("averageScore")).toList();

        return new AverageOption(averageList, dataList);
    }
}

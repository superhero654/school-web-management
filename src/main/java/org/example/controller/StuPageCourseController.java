package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Course;
import org.example.pojo.Result;
import org.example.service.CourseService;
import org.example.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/stuCourses")
@RestController
public class StuPageCourseController {

    @Autowired
    private CourseService courseService;

    //查询所有课程数据
    @GetMapping
    public Result list() {
        log.info("学生id: {},查询全部的课程数据",CurrentHolder.getCurrentId());
        List<Course> courseList = courseService.findAll();
        return Result.success(courseList);
    }

    //根据id查询课程数据
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("学生id: {},查询课程数据: {},",CurrentHolder.getCurrentId(), id);
        Course course = courseService.getById(id);
        return Result.success(course);
    }
}

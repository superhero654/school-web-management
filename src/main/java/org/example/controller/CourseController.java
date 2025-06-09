package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Course;
import org.example.pojo.Result;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/courses")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    //查询所有课程数据
    @GetMapping
    public Result list() {
        log.info("查询全部的课程数据");
        List<Course> courseList = courseService.findAll();
        return Result.success(courseList);
    }
    //删除课程数据
    @DeleteMapping
    public Result delete(Integer id){
        log.info("删除课程数据: {}",id);
        courseService.deleteById(id);
        return Result.success();
    }

    //添加课程数据
    @PostMapping
    public Result add(@RequestBody Course course){
        log.info("添加课程数据: {}",course);
        courseService.add(course);
        return Result.success();
    }

    //根据id查询课程数据
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询课程数据: {}",id);
        Course course = courseService.getById(id);
        return Result.success(course);
    }

    //修改课程数据
    @PutMapping
    public Result update(@RequestBody Course course){
        log.info("修改课程数据: {}",course);
        courseService.update(course);
        return Result.success();
    }
}

package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.pojo.Teacher;
import org.example.pojo.TeacherQueryParam;
import org.example.service.TeacherService;
import org.example.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/stuTeachers")
@RestController
public class StuPageTeacherController {

    @Autowired
    private TeacherService teacherService;

    //分页查询
    @GetMapping
    public Result page(TeacherQueryParam teacherQueryParam)
    {
        log.info("学生id:{},分页查询教师：{}",CurrentHolder.getCurrentId(),teacherQueryParam);
        PageResult<Teacher> pageResult = teacherService.page(teacherQueryParam);
        return Result.success(pageResult);
    }

    //根据id查询教师信息
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("学生id:{},查询教师：{}",CurrentHolder.getCurrentId(),id);
        Teacher teacher = teacherService.getInfo(id);
        return Result.success(teacher);
    }
}

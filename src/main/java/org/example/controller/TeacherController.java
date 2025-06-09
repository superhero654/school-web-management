package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.*;
import org.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//教师管理
@Slf4j
@RequestMapping("/teachers")
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    //分页查询
    @GetMapping
    public Result page(TeacherQueryParam teacherQueryParam)
    {
        log.info("分页查询教师：{}",teacherQueryParam);
        PageResult<Teacher> pageResult = teacherService.page(teacherQueryParam);
        return Result.success(pageResult);
    }

    //新增教师
    @PostMapping
    public Result save(@RequestBody Teacher teacher){
        log.info("新增教师：{}",teacher);
        teacherService.save(teacher);
        return Result.success();
    }

    //删除教师-list集合
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除教师：{}", ids);
        teacherService.delete(ids);
        return Result.success();
    }

    //根据id查询教师信息
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("查询教师：{}",id);
        Teacher teacher = teacherService.getInfo(id);
        return Result.success(teacher);
    }

    //修改教师
    @PutMapping
    public Result update(@RequestBody Teacher teacher){
        log.info("修改教师：{}",teacher);
        teacherService.update(teacher);
        return Result.success();
    }

    //根据姓名查询教师信息
    @GetMapping("/name/{name}")
    public Result get(@PathVariable String name){
        log.info("查询教师：{}",name);
        Teacher teacher = teacherService.getInfoName(name);
        return Result.success(teacher);
    }
}

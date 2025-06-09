package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.*;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//学生管理
@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    //分页查询
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam)
    {
        log.info("分页查询学生：{}",studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    //新增学生
    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("新增学生：{}",student);
        studentService.save(student);
        return Result.success();
    }

    //删除学生-list集合
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除学生：{}", ids);
        studentService.delete(ids);
        return Result.success();
    }

    //根据id查询学生信息
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("查询学生：{}",id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    //根据姓名查询学生信息
    @GetMapping("/name/{name}")
    public Result get(@PathVariable String name){
        log.info("查询学生：{}",name);
        Student student = studentService.getInfoName(name);
        return Result.success(student);
    }

    //修改学生
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学生：{}",student);
        studentService.update(student);
        return Result.success();
    }
}

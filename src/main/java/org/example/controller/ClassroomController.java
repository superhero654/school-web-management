package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Classroom;
import org.example.pojo.Result;
import org.example.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/classrooms")
@RestController
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    //查询所有教室数据
    @GetMapping
    public Result list() {
        log.info("查询全部的教室数据");
        List<Classroom> classroomList = classroomService.findAll();
        return Result.success(classroomList);
    }
    //删除教室数据
    @DeleteMapping
    public Result delete(Integer id){
        log.info("删除教室数据: {}",id);
        classroomService.deleteById(id);
        return Result.success();
    }

    //添加教室数据
    @PostMapping
    public Result add(@RequestBody Classroom classroom){
        log.info("添加教室数据: {}",classroom);
        classroomService.add(classroom);
        return Result.success();
    }

    //根据id查询教室数据
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询教室数据: {}",id);
        Classroom classroom = classroomService.getById(id);
        return Result.success(classroom);
    }

    //修改教室数据
    @PutMapping
    public Result update(@RequestBody Classroom classroom){
        log.info("修改教室数据: {}",classroom);
        classroomService.update(classroom);
        return Result.success();
    }
}

package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.ClassroomSchedule;
import org.example.pojo.Result;
import org.example.service.ClassroomScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/classroomSchedule")
@RestController
public class ClassroomScheduleController {

    @Autowired
    private ClassroomScheduleService classroomScheduleService;

    @GetMapping
    public Result list() {
        log.info("查询全部的教室预定数据");
        List<ClassroomSchedule> classroomScheduleList = classroomScheduleService.findAll();
        return Result.success(classroomScheduleList);
    }


    @DeleteMapping
    public Result delete(Integer id){
        log.info("删除教室预定数据: {}",id);
        classroomScheduleService.deleteById(id);
        return Result.success();
    }


    @PostMapping
    public Result add(@RequestBody ClassroomSchedule classroomSchedule){
        log.info("添加教室预定数据: {}",classroomSchedule);
        classroomScheduleService.add(classroomSchedule);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询教室预定数据: {}",id);
        ClassroomSchedule classroomSchedule = classroomScheduleService.getById(id);
        return Result.success(classroomSchedule);
    }


    @PutMapping
    public Result update(@RequestBody ClassroomSchedule classroomSchedule){
        log.info("修改教室预定数据: {}",classroomSchedule);
        classroomScheduleService.update(classroomSchedule);
        return Result.success();
    }
}

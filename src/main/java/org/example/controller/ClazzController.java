package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Clazz;
import org.example.pojo.Result;
import org.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    //查询所有班级数据
    @GetMapping
    public Result list() {
        log.info("查询全部的班级数据");
        List<Clazz> classList = clazzService.findAll();
        return Result.success(classList);
    }
    //删除班级数据
    @DeleteMapping
    public Result delete(Integer id){
        log.info("删除班级数据: {}",id);
        clazzService.deleteById(id);
        return Result.success();
    }

    //添加班级数据
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加班级数据: {}",clazz);
        clazzService.add(clazz);
        return Result.success();
    }

    //根据id查询班级数据
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询班级数据: {}",id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    //修改班级数据
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级数据: {}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }
}

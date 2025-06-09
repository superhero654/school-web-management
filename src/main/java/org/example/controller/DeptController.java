package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Dept;
import org.example.pojo.Result;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //查询所有部门数据
    @GetMapping
    public Result list() {
        log.info("查询全部的部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
    //删除部门数据
    @DeleteMapping
    public Result delete(Integer id){
        log.info("删除部门数据: {}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    //添加部门数据
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加部门数据: {}",dept);
        deptService.add(dept);
        return Result.success();
    }

    //根据id查询部门数据
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询部门数据: {}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    //修改部门数据
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门数据: {}",dept);
        deptService.update(dept);
        return Result.success();
    }
}

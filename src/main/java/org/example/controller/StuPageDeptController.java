package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Dept;
import org.example.pojo.Result;
import org.example.service.DeptService;
import org.example.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/stuDepts")
@RestController
public class StuPageDeptController {

    @Autowired
    private DeptService deptService;

    //查询所有部门数据
    @GetMapping
    public Result list() {
        log.info("学生id: {},查询全部的部门数据",CurrentHolder.getCurrentId());
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    //根据id查询部门数据
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("学生id: {},查询部门数据: {},",CurrentHolder.getCurrentId(), id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
}

package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Emp;
import org.example.pojo.EmpQueryParam;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.service.EmpService;
import org.example.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/stuEmps")
@RestController
public class StuPageEmpController {

    @Autowired
    private EmpService empService;

    //分页查询
    @GetMapping
    public Result page(EmpQueryParam empQueryParam)
    {
        log.info("学生id：{},分页查询职工：{}",CurrentHolder.getCurrentId(),empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    //根据id查询职工信息
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("学生id：{},查询职工：{}",CurrentHolder.getCurrentId(),id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
}

package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Emp;
import org.example.pojo.EmpQueryParam;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//职工管理
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;
    //分页查询
    @GetMapping
    public Result page(EmpQueryParam empQueryParam)
    {
        log.info("分页查询职工：{}",empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    //新增职工
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增职工：{}",emp);
        empService.save(emp);
        return Result.success();
    }

    //删除职工-list集合
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除职工：{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    //根据id查询职工信息
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("查询职工：{}",id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    //修改职工
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改职工：{}",emp);
        empService.update(emp);
        return Result.success();
    }
}

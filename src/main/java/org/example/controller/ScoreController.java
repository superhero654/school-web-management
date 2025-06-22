package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.*;
import org.example.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//成绩管理
@Slf4j
@RequestMapping("/score")
@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    //分页查询
    @GetMapping
    public Result page(ScoreQueryParam scoreQueryParam)
    {
        log.info("分页查询成绩：{}",scoreQueryParam);
        PageResult<Score> pageResult = scoreService.page(scoreQueryParam);
        return Result.success(pageResult);
    }

    //新增成绩
    @PostMapping
    public Result save(@RequestBody Score score){
        log.info("新增成绩：{}",score);
        scoreService.save(score);
        return Result.success();
    }

    //删除成绩
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除成绩：{}", ids);
        scoreService.delete(ids);
        return Result.success();
    }

    //根据id查询成绩
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("查询成绩：{}",id);
        List<Score> score = scoreService.getInfo(id);
        return Result.success(score);
    }

    @GetMapping("/admin/{id}")
    public Result getAdmin(@PathVariable Integer id){
        log.info("查询单个成绩：{}",id);
        Score score = scoreService.getAdminInfo(id);
        return Result.success(score);
    }

    //修改成绩
    @PutMapping
    public Result update(@RequestBody Score score){
        log.info("修改成绩：{}",score);
        scoreService.update(score);
        return Result.success();
    }
}

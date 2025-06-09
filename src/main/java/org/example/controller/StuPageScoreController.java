package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Result;
import org.example.pojo.Score;
import org.example.service.ScoreService;
import org.example.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/stuScore")
@RestController
public class StuPageScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public Result get(){
        log.info("学生id:{},查询成绩", CurrentHolder.getCurrentId());
        List<Score> score = scoreService.stuPage(CurrentHolder.getCurrentId());
        return Result.success(score);
    }
}

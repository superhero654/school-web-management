package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.ScoreMapper;
import org.example.pojo.PageResult;
import org.example.pojo.Score;
import org.example.pojo.ScoreQueryParam;
import org.example.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public PageResult<Score> page(ScoreQueryParam scoreQueryParam) {
        PageHelper.startPage(scoreQueryParam.getPage(),scoreQueryParam.getPageSize());

        List<Score> scoreList = scoreMapper.page(scoreQueryParam);

        Page<Score> scorePage = (Page<Score>) scoreList;
        return new PageResult<Score>(scorePage.getTotal(), scorePage.getResult());
    }

    @Override
    public void save(Score score) {
        score.setCreateTime(LocalDateTime.now());
        scoreMapper.insert(score);
    }

    @Override
    public void delete(List<Integer> ids) {
        scoreMapper.deleteByIds(ids);
    }

    @Override
    public List<Score> getInfo(Integer id) {
        return scoreMapper.getById(id);
    }

    @Override
    public void update(Score score) {
        scoreMapper.updateById(score);
    }

    @Override
    public List<Score> stuPage(Integer id) {
        return scoreMapper.stuPage(id);
    }
}

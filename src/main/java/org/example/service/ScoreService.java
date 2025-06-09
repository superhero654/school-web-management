package org.example.service;

import org.example.pojo.PageResult;
import org.example.pojo.Score;
import org.example.pojo.ScoreQueryParam;

import java.util.List;

public interface ScoreService {
    void save(Score score);

    void delete(List<Integer> ids);

    List<Score> getInfo(Integer id);

    void update(Score score);

    PageResult<Score> page(ScoreQueryParam scoreQueryParam);

    List<Score> stuPage(Integer id);
}

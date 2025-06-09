package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Score;
import org.example.pojo.ScoreQueryParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface ScoreMapper {
    List<Score> page(ScoreQueryParam scoreQueryParam);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Score score);

    void deleteByIds(List<Integer> ids);

    List<Score> getById(Integer id);

    void updateById(Score score);

    @MapKey("pos")
    List<Map<String, Object>> countStudentRankData();

    @MapKey("courseName")
    List<Map<String, Object>> countStudentAverageData();

    List<Score> stuPage(Integer id);
}

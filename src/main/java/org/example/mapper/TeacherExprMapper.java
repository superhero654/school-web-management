package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.TeacherExpr;

import java.util.List;

//教师工作经历
@Mapper
public interface TeacherExprMapper {
    //批量保存教师工作经历信息
    void insertBatch(List<TeacherExpr> exprList);

    //根据id批量删除教师工作经历信息
    void deleteByTeacherIds(List<Integer> teacherIds);
}

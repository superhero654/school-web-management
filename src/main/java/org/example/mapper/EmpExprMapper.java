package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.EmpExpr;

import java.util.List;

//职工工作经历
@Mapper
public interface EmpExprMapper {
    //批量保存职工工作经历信息
    void insertBatch(List<EmpExpr> exprList);

    //根据职工id批量删除职工工作经历信息
    void deleteByEmpIds(List<Integer> empIds);
}

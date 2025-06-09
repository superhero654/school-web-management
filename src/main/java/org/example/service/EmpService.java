package org.example.service;

import org.example.pojo.Emp;
import org.example.pojo.EmpQueryParam;
import org.example.pojo.PageResult;

import java.util.List;

public interface EmpService {
    //分页查询
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    //新增职工信息·
    void save(Emp emp);

    //批量删除职工信息
    void delete(List<Integer> ids);

    //根据id查询信息
    Emp getInfo(Integer id);

    //修改职工信息
    void update(Emp emp);

}

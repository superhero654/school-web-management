package org.example.service;

import org.example.pojo.Dept;
import org.example.pojo.Feedback;

import java.util.List;

public interface DeptService {
    //查询所有部门数据
    List<Dept> findAll();
    //删除部门数据
    void deleteById(Integer id);
    //新增部门数据
    void add(Dept dept);
//    根据id查询部门数据
    Dept getById(Integer id);
//    修改部门数据
    void update(Dept dept);

//    添加反馈
    void addAdvice(Feedback feedback);

    List<Feedback> findAllAdvice();

    Feedback getAdviceById(Integer id);
}

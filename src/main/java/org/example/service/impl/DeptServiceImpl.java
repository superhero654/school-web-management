package org.example.service.impl;

import org.example.mapper.DeptMapper;
import org.example.pojo.Dept;
import org.example.pojo.Feedback;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //1.补全基础属性-创建时间、更新时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        //2.调用Mapper接口
        deptMapper.add(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        //1.补全基础属性-更新时间
        dept.setUpdateTime(LocalDateTime.now());
        //2.调用Mapper接口方法更新数据
        deptMapper.update(dept);
    }

    @Override
    public void addAdvice(Feedback feedback) {
        feedback.setSubmitTime(LocalDateTime.now());

        deptMapper.addAdvice(feedback);
    }

    @Override
    public List<Feedback> findAllAdvice() {
        return deptMapper.findAllAdvice();
    }

    @Override
    public Feedback getAdviceById(Integer id) {
        return deptMapper.getAdviceById(id);
    }
}

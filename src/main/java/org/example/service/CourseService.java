package org.example.service;

import org.example.pojo.Course;

import java.util.List;

public interface CourseService {
    //查询所有课程数据
    List<Course> findAll();

    //删除课程数据
    void deleteById(Integer id);

    //新增课程数据
    void add(Course course);

    //    根据id查询课程数据
    Course getById(Integer id);

    //    修改课程数据
    void update(Course course);
}

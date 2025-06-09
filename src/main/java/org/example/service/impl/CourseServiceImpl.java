package org.example.service.impl;

import org.example.mapper.CourseMapper;
import org.example.pojo.Course;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        courseMapper.deleteById(id);
    }

    @Override
    public void add(Course course) {
        course.setCreateTime(LocalDateTime.now());
        course.setUpdateTime(LocalDateTime.now());

        courseMapper.add(course);
    }

    @Override
    public Course getById(Integer id) {
        return courseMapper.getById(id);
    }

    @Override
    public void update(Course course) {
        course.setUpdateTime(LocalDateTime.now());

        courseMapper.update(course);
    }
}

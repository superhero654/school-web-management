package org.example.service;

import org.example.pojo.*;

import java.util.List;

public interface TeacherService {
    //分页查询
    PageResult<Teacher> page(TeacherQueryParam teacherQueryParam);

    //新增教师信息
    void save(Teacher teacher);

    //批量删除教师信息
    void delete(List<Integer> ids);

    //根据id查询信息
    Teacher getInfo(Integer id);

    //修改教师信息
    void update(Teacher teacher);

    //根据姓名查询信息
    Teacher getInfoName(String name);
}

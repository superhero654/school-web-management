package org.example.service;

import org.example.pojo.LoginInfo;
import org.example.pojo.PageResult;
import org.example.pojo.Student;
import org.example.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    //分页查询
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    //新增学生信息
    void save(Student student);

    //批量删除学生信息
    void delete(List<Integer> ids);

    //根据id查询信息
    Student getInfo(Integer id);

    //修改学生信息
    void update(Student student);

     //登录
    LoginInfo login(Student student);

    //根据姓名查询信息
    Student getInfoName(String name);
}

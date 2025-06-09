package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.example.mapper.StudentMapper;
import org.example.pojo.*;
import org.example.service.StudentLogService;
import org.example.service.StudentService;
import org.example.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentLogService studentLogService;

    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());

        List<Student> studentList = studentMapper.page(studentQueryParam);

        Page<Student> studentPage = (Page<Student>) studentList;
        return new PageResult<Student>(studentPage.getTotal(), studentPage.getResult());
    }

    @Override
    public void save(Student student) {
        //保存学生的基本信息
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);

        StudentLog studentLog = new StudentLog(null,LocalDateTime.now(),"新增学生："+student);
        studentLogService.insertLog(studentLog);
    }

    @Override
    public void delete(List<Integer> ids) {
        //批量删除学生基本信息
        studentMapper.deleteByIds(ids);
    }

    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        //根据id修改学生基本信息
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateById(student);
    }

    @Override
    public LoginInfo login(Student student) {
        //1.调用Mapper接口，根据用户名和密码查询学生信息
        Student s = studentMapper.selectByUsernameAndPassword(student);
        //2.判断：是否存在这个学生，如果存在，组装登录成功的信息；如果不存在，返回null
        if(s != null){
            log.info("学生登录成功：{}",s);
            //生成JWT令牌
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",s.getId());
            claims.put("username",s.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return new LoginInfo(s.getId(),s.getUsername(),s.getName(),jwt);
        }
        return null;
    }

    @Override
    public Student getInfoName(String name) {
        return studentMapper.getInfoName(name);
    }
}

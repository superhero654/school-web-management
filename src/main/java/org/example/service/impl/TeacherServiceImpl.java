package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.TeacherExprMapper;
import org.example.mapper.TeacherMapper;
import org.example.pojo.*;
import org.example.service.TeacherLogService;
import org.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherExprMapper teacherExprMapper;

    @Autowired
    private TeacherLogService teacherLogService;

    @Override
    public PageResult<Teacher> page(TeacherQueryParam teacherQueryParam) {
        PageHelper.startPage(teacherQueryParam.getPage(),teacherQueryParam.getPageSize());

        List<Teacher> teacherList = teacherMapper.page(teacherQueryParam);

        Page<Teacher> teacherPage = (Page<Teacher>) teacherList;
        return new PageResult<Teacher>(teacherPage.getTotal(), teacherPage.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Teacher teacher) {
        try {
            //1.保存教师的基本信息
            teacher.setCreateTime(LocalDateTime.now());
            teacher.setUpdateTime(LocalDateTime.now());
            teacherMapper.insert(teacher);

            //2.仅保存教师的经历信息
            Integer teacherId = teacher.getId();
            List<TeacherExpr> exprList = teacher.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(teacherExpr-> teacherExpr.setTeacherId(teacherId));
                teacherExprMapper.insertBatch(exprList);
            }
        } finally {
            TeacherLog teacherLog = new TeacherLog(null,LocalDateTime.now(),"新增教师："+teacher);
            teacherLogService.insertLog(teacherLog);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        //1.批量删除教师基本信息
        teacherMapper.deleteByIds(ids);

        //2.批量删除教师工作经历信息
        teacherExprMapper.deleteByTeacherIds(ids);
    }

    @Override
    public Teacher getInfo(Integer id) {
        return teacherMapper.getById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Teacher teacher) {
        //1.根据id修改教师基本信息
        teacher.setUpdateTime(LocalDateTime.now());
        teacherMapper.updateById(teacher);

        //2.根据id修改教师工作经历信息
        teacherExprMapper.deleteByTeacherIds(Arrays.asList(teacher.getId()));

        List<TeacherExpr> exprList = teacher.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(teacherExpr-> teacherExpr.setTeacherId(teacher.getId()));
            teacherExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public Teacher getInfoName(String name) {
        return teacherMapper.getInfoName(name);
    }
}

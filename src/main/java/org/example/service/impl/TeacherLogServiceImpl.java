package org.example.service.impl;

import org.example.mapper.TeacherLogMapper;
import org.example.pojo.TeacherLog;
import org.example.service.TeacherLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherLogServiceImpl implements TeacherLogService {

    @Autowired
    private TeacherLogMapper teacherLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(TeacherLog teacherLog) {
        teacherLogMapper.insert(teacherLog);
    }
}

package org.example.service.impl;

import org.example.mapper.StudentLogMapper;
import org.example.pojo.StudentLog;
import org.example.service.StudentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLogServiceImpl implements StudentLogService {

    @Autowired
    private StudentLogMapper studentLogMapper;

    @Override
    public void insertLog(StudentLog studentLog) {
        studentLogMapper.insert(studentLog);
    }
}

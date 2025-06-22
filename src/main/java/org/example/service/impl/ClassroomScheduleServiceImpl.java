package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mapper.ClassroomScheduleMapper;
import org.example.pojo.ClassroomSchedule;
import org.example.service.ClassroomScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ClassroomScheduleServiceImpl implements ClassroomScheduleService {

    @Autowired
    private ClassroomScheduleMapper classroomScheduleMapper;

    @Override
    public List<ClassroomSchedule> findAll() {
        return classroomScheduleMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        classroomScheduleMapper.deleteById(id);
    }

    @Override
    public void add(ClassroomSchedule classroomSchedule) {
        classroomSchedule.setCreateTime(LocalDateTime.now());
        classroomScheduleMapper.add(classroomSchedule);
    }

    @Override
    public ClassroomSchedule getById(Integer id) {
        return classroomScheduleMapper.getById(id);
    }

    @Override
    public void update(ClassroomSchedule classroomSchedule) {
        classroomScheduleMapper.update(classroomSchedule);
    }
}

package org.example.service;

import org.example.pojo.ClassroomSchedule;

import java.util.List;

public interface ClassroomScheduleService {
    List<ClassroomSchedule> findAll();

    void deleteById(Integer id);

    void add(ClassroomSchedule classroomSchedule);

    ClassroomSchedule getById(Integer id);

    void update(ClassroomSchedule classroomSchedule);
}

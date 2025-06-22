package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mapper.ClassroomMapper;
import org.example.pojo.Classroom;
import org.example.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomMapper classroomMapper;
    @Override
    public List<Classroom> findAll() {
        return classroomMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        classroomMapper.deleteById(id);
    }

    @Override
    public void add(Classroom classroom) {
        classroomMapper.add(classroom);
    }

    @Override
    public Classroom getById(Integer id) {
        return classroomMapper.getById(id);
    }

    @Override
    public void update(Classroom classroom) {
        classroomMapper.update(classroom);
    }
}

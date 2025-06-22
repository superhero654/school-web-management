package org.example.service;

import org.example.pojo.Classroom;

import java.util.List;

public interface ClassroomService {
    List<Classroom> findAll();

    void deleteById(Integer id);

    void add(Classroom classroom);

    Classroom getById(Integer id);

    void update(Classroom classroom);
}

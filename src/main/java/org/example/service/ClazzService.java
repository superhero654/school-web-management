package org.example.service;

import org.example.pojo.Clazz;

import java.util.List;

public interface ClazzService {
    List<Clazz> findAll();

    void deleteById(Integer id);

    void add(Clazz clazz);

    Clazz getById(Integer id);

    void update(Clazz clazz);
}

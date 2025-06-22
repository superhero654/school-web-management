package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Classroom;

import java.util.List;

@Mapper
public interface ClassroomMapper {
    @Select("select classroom.id, name, capacity, type, cs.status from classroom left join classroom_schedule cs on classroom.id = cs.classroom_id")
    List<Classroom> findAll();

    @Delete("delete from classroom where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into classroom(id, name, capacity, type) values(#{id},#{name},#{capacity},#{type})")
    void add(Classroom classroom);

    @Select("select c.id, c.name, capacity, type, cs.status from classroom c left join classroom_schedule cs on c.id = cs.classroom_id where c.id= #{id}")
    Classroom getById(Integer id);

    @Update("update classroom set name=#{name},capacity=#{capacity},type=#{type} where id=#{id}")
    void update(Classroom classroom);
}

package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Course;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select id,name,credit,create_time,update_time from course order by update_time DESC")
    List<Course> findAll();

    //根据id删除课程
    @Delete("delete from course where id=#{id}")
    void deleteById(Integer id);

    //添加课程
    @Insert("insert into course(name,credit,create_time,update_time) values(#{name},#{credit},#{createTime},#{updateTime})")
    void add(Course course);

    //根据id查询课程
    @Select("select id,name,credit,create_time,update_time from course where id=#{id}")
    Course getById(Integer id);

    //更新课程
    @Update("update course set name=#{name},credit=#{credit},update_time=#{updateTime} where id=#{id}")
    void update(Course course);
}

package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Clazz;

import java.util.List;

@Mapper
public interface ClazzMapper {
    @Select("select id,name,create_time,update_time from clazz order by update_time DESC")
    List<Clazz> findAll();

    //根据id删除班级
    @Delete("delete from clazz where id=#{id}")
    void deleteById(Integer id);

    //添加班级
    @Insert("insert into clazz(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void add(Clazz clazz);

    //根据id查询班级
    @Select("select id,name,create_time,update_time from clazz where id=#{id}")
    Clazz getById(Integer id);

    //更新班级
    @Update("update clazz set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Clazz clazz);
}

package org.example.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.TeacherLog;

@Mapper
public interface TeacherLogMapper {

    @Insert("insert into teacher_log (operate_time, info) values (#{operateTime}, #{info})")
    public void insert(TeacherLog teacherLog);

}

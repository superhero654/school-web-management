package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.StudentLog;

@Mapper
public interface StudentLogMapper {
    @Insert("insert into student_log (operate_time, info) values (#{operateTime}, #{info})")
    void insert(StudentLog studentLog);
}

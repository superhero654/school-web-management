package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.ClassroomSchedule;

import java.util.List;

@Mapper
public interface ClassroomScheduleMapper {
    @Select("select classroom_schedule.id, classroom_id, start_time, end_time, purpose, user_name, classroom_schedule.status, create_time, c.name as classroom_name from classroom_schedule LEFT JOIN classroom c on classroom_schedule.classroom_id=c.id")
    List<ClassroomSchedule> findAll();

    @Delete("delete from classroom_schedule where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into classroom_schedule(classroom_id, start_time, end_time, purpose, user_name, status) values(#{classroomId},#{startTime},#{endTime},#{purpose},#{userName},#{status})")
    void add(ClassroomSchedule classroomSchedule);

    @Select("select classroom_schedule.id, classroom_id, start_time, end_time, purpose, user_name, classroom_schedule.status, create_time, c.name as classroom_name from classroom_schedule LEFT JOIN classroom c on classroom_schedule.classroom_id=c.id where classroom_schedule.id= #{id}")
    ClassroomSchedule getById(Integer id);

    @Insert("update classroom_schedule set classroom_id=#{classroomId},start_time=#{startTime},end_time=#{endTime},purpose=#{purpose},user_name=#{userName},status=#{status} where id=#{id}")
    void update(ClassroomSchedule classroomSchedule);
}

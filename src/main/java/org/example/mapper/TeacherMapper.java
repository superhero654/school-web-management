package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Teacher;
import org.example.pojo.TeacherQueryParam;

import java.util.List;
import java.util.Map;

//教师信息
@Mapper
public interface TeacherMapper {
    //条件查询教师信息
    public List<Teacher> page(TeacherQueryParam teacherQueryParam);

    //保存教师信息
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into teacher(name,gender,phone,title,hire_date,course_id,create_time,update_time)" +
            "values(#{name},#{gender},#{phone},#{title},#{hireDate},#{courseId},#{createTime},#{updateTime})")
    void insert(Teacher teacher);

    //根据id批量删除教师
    void deleteByIds(List<Integer> ids);

    //根据id查询教师信息和工作经历信息
    Teacher getById(Integer id);

    //根据id更新教师信息
    void updateById(Teacher teacher);

    //统计教师职位人数
    @MapKey("pos")
    List<Map<String, Object>> countTeacherTitleData();

    //统计教师性别人数
    @MapKey("name")
    List<Map<String, Object>> countTeacherGenderData();

    //根据教师姓名查询教师信息
    Teacher getInfoName(String name);
}

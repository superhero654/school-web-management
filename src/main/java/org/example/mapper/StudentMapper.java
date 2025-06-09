package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Student;
import org.example.pojo.StudentQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    //条件查询学生信息
    List<Student> page(StudentQueryParam studentQueryParam);

    //保存学生信息
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into student(username,password,name,gender,phone,email,admission_date,clazz_id,create_time,update_time)" +
            "values(#{username},#{password},#{name},#{gender},#{phone},#{email},#{admissionDate},#{clazzId},#{createTime},#{updateTime})")
    void insert(Student student);

    //根据id批量删除学生
    void deleteByIds(List<Integer> ids);

    //根据id查询学生信息
    Student getById(Integer id);

    //根据id更新学生信息
    void updateById(Student student);

    //统计学生班级人数
    @MapKey("name")
    List<Map<String, Object>> countStudentClazzData();

    //统计学生性别人数
    @MapKey("gender")
    List<Map<String, Object>> countStudentGenderData();

    //根据用户名和密码查询学生信息
    @Select("select id,username,name from student where username=#{username} and password=#{password}")
    Student selectByUsernameAndPassword(Student student);

    //根据姓名查询学生信息
    Student getInfoName(String name);
}

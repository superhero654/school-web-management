package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Dept;
import org.example.pojo.Feedback;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select id,name,create_time,update_time from dept order by update_time DESC")
    List<Dept> findAll();

    //根据id删除部门
    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);

    //添加部门
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    //根据id查询部门
    @Select("select id,name,create_time,update_time from dept where id=#{id}")
    Dept getById(Integer id);

    //更新部门
    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);

    @Insert("insert into feedback(name,dept_id,content,submit_time,is_completed) values(#{name},#{deptId},#{content},#{submitTime},#{isCompleted})")
    void addAdvice(Feedback feedback);

    @Select("SELECT feedback.id,feedback.name,dept_id,d.name AS dept_name,content,submit_time,is_completed FROM feedback \n" +
            "LEFT JOIN dept d ON feedback.dept_id = d.id\n" +
            "ORDER BY submit_time DESC;")
    List<Feedback> findAllAdvice();

    @Select("select feedback.id,feedback.name,dept_id,d.name AS dept_name,content,submit_time,is_completed from feedback LEFT JOIN dept d ON feedback.dept_id = d.id where feedback.id=#{id}")
    Feedback getAdviceById(Integer id);
}

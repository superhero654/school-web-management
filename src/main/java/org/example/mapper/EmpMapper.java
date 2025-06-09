package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Emp;
import org.example.pojo.EmpQueryParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

//职工信息
@Mapper
public interface EmpMapper {
    //条件查询职工信息
    public List<Emp> page(EmpQueryParam empQueryParam);

    //保存职工信息
    @Options(useGeneratedKeys = true,keyProperty = "id")//插入成功后，将主键值回填到emp对象中，获取到生成的主键--主键返回
    @Insert("insert into emp(name,gender,phone,salary,entry_date,dept_id,create_time,update_time)" +
            "values(#{name},#{gender},#{phone},#{salary},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    //根据id批量删除职工
    void deleteByIds(List<Integer> ids);

    //根据id查询职工信息和工作经历信息
    Emp getById(Integer id);

    //根据id更新职工信息
    void updateById(Emp emp);

    //统计职工职位人数
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    //统计职工性别人数
    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();

}

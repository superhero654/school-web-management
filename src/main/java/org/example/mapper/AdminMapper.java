package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.Admin;

@Mapper
public interface AdminMapper {
    @Select("select id,username,name from admin where username=#{username} and password=#{password}")
    Admin selectByUsernameAndPassword(Admin admin);

    @Update("update admin set password=#{password} where id = 1")
    void updateById(Admin admin);
}

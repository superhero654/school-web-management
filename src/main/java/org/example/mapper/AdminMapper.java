package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Admin;

@Mapper
public interface AdminMapper {
    @Select("select id,username,name from admin where username=#{username} and password=#{password}")
    Admin selectByUsernameAndPassword(Admin admin);
}

package org.example.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Student {
    private Integer id; //ID,主键
    private String username; //用户名
    private String password; //密码
    private String name; //姓名
    private Integer gender; //性别, 1:男, 2:女
    private String phone; //手机号
    private String email;//电子邮箱
    private LocalDate admissionDate; //入学日期
    private Integer clazzId; //班级id
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间

    //封装班级名称
    private String clazzName;
}

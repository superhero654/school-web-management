package org.example.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Teacher {
    private Integer id; //ID,主键
    private String name; //姓名
    private Integer gender; //性别, 1:男, 2:女
    private String phone; //手机号
    private Integer title; //职位, 1:教授,2:副教授,3:讲师,4:企业教师
    private LocalDate hireDate; //入职日期
    private Integer courseId;//主讲课程
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间

    //封装课程名称
    private String courseName;
    //封装工作信息
    private List<TeacherExpr> exprList;
}

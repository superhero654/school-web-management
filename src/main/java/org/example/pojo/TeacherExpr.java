package org.example.pojo;

import lombok.Data;

import java.time.LocalDate;

/**
 * 工作经历
 */
@Data
public class TeacherExpr {
    private Integer id; //ID
    private Integer teacherId; //教师ID
    private LocalDate begin; //开始时间
    private LocalDate end; //结束时间
    private String site; //工作地点
    private String job; //职位
}

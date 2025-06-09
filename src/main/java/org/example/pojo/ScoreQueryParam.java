package org.example.pojo;

import lombok.Data;

@Data
public class ScoreQueryParam {
    public Integer page = 1;          // 页码
    private Integer pageSize = 10;     // 每页展示记录数

    // 关联ID查询条件
    private Integer studentId;        // 学生ID
    private Integer courseId;         // 课程ID
    private Integer teacherId;        // 教师ID

    // 模糊查询条件
    private String studentName;
    private String courseName;
    private String teacherName;

    // 成绩范围查询
    private double min = 0.0;// 最小最终成绩
    private double max = 100.0;// 最大最终成绩

}

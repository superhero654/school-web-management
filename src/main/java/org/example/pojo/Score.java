package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    private Integer id;//成绩id
    private Integer studentId;//学生id
    private Integer courseId;//课程id
    private Integer teacherId;//授课教师id
    private Double regularScore;//平时成绩
    private Double examScore;//考试成绩
    private Double finalScore;//最终成绩
    private LocalDateTime createTime;

    private String studentName;
    private String courseName;
    private String teacherName;
}

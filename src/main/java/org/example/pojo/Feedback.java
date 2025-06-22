package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    private Integer id;
    private String name;
    private Integer deptId;
    private String content;
    private LocalDateTime submitTime;
    private Integer isCompleted = 0;

    private String deptName;
}

package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    private Integer id;
    private String name;
    private Integer capacity;
    private String type;
    private String status = "空余";

}

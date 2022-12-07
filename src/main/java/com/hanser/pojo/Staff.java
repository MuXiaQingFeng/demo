package com.hanser.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    private int id;
    private String staffCode;
    private String staffPassword;
    private int grade;
    private int departmentId;
    private String departmentName;
    private String type;
}

package com.qf.pojo;

import lombok.Data;

import java.util.List;
@Data
public class Subject {
    private Integer id;
    private String name;
    private Integer grade;
    private List<Student> studentList;
}

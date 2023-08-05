package com.sq.pojo;

import lombok.Data;

import java.util.List;
@Data
public class Subject {
    private Integer id;
    private String name;
    private Integer grade;
    //多对多，都是多的一方
    private List<Student> student;
}

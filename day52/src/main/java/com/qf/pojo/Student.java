package com.qf.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private List<Subject> subjectList;
}

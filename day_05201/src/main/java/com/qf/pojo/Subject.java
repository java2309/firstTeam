package com.qf.pojo;

import lombok.Data;

import java.util.List;

/**
 * 课程
 */
@Data
public class Subject {

    private Integer id;
    private String name;
    private Integer grade;
    //一个课程对应多个学生
    private List<Student> studentList;
}
package com.qf.pojo;

import lombok.Data;


import java.util.List;

/**
 * 学生
 */
@Data
public class Student {

    private Integer id;
    private String name;
    private String sex;

    //多对多，都是多的一方,先进先出
    private List<Subject> subjectList;

}
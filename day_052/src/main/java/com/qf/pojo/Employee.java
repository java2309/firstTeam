package com.qf.pojo;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String name;
    private Double salary;
    //一个员工对应这一个部门(一对一)
    private Department department;
}

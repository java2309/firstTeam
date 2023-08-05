package com.sq.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private Integer id;
    private String name;
    private Double salary;

    private List<Department> departments;
}

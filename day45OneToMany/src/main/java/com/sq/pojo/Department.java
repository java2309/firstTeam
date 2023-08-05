package com.sq.pojo;

import lombok.Data;

import java.util.List;
@Data
public class Department {
    private Integer id;
    private String name;
    private String location;

    private List<Employee> employee;

}

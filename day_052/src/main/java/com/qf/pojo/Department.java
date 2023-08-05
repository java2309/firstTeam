package com.qf.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private Integer id;
    private String name;
    private String location;
    //一个部门对应这多个员工(一对多)
    private List<Employee> emps;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public List<Employee> getEmps() {
//        return emps;
//    }
//
//    public void setEmps(List<Employee> emps) {
//        this.emps = emps;
//    }
}

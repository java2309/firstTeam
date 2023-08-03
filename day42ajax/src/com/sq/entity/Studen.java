package com.sq.entity;

public class Studen {
    private Integer id;
    private String stu_name;
    private Integer age;
    private String info;

    public Studen() {
    }

    public Studen(Integer id, String stu_name, Integer age, String info) {
        this.id = id;
        this.stu_name = stu_name;
        this.age = age;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

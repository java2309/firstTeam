package com.ybbb.pojo;

public class Student {
    private Integer id;
    private String stu_name;
    private Integer  age;
    private String sex;
    private String info;
    private Integer t_id;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stu_name='" + stu_name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", info='" + info + '\'' +
                ", t_id=" + t_id +
                '}';
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Student() {
    }
}

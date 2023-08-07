package com.sq.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Car car;

    public User() {
    }

    public User(Integer id, String name, String password, Car car) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.car = car;
        System.out.println("有参构造1");
    }
    public User( String name,Integer id, String password, Car car) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.car = car;
        System.out.println("有参构造2");
    }

    public void initUser(){
        System.out.println("初始化");
    }
    public void destroyUser(){
        System.out.println("销毁");
    }
}

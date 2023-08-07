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
    public void initUser(){
        System.out.println("初始化");
    }
    public void destroyUser(){
        System.out.println("销毁");
    }
}

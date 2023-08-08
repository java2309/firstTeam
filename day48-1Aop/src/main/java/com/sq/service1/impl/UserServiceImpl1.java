package com.sq.service1.impl;

import com.sq.service.UserService;

public class UserServiceImpl1 implements UserService {
    @Override
    public void add() {
        System.out.println("添加");
       //int a = 10/0;
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

    @Override
    public void update() {
        System.out.println("修改");
    }
}

package com.qf.dao.impl;

import com.qf.dao.UserDao;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl1 implements UserDao {
    @Override
    public void addUser() {
        System.out.println("不好意思，乾坤大挪移");
    }
}

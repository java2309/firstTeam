package com.qf.dao;

import com.qf.entity.User;

import java.util.List;
import java.util.Objects;

public interface UserDao {


    List<User> select(Integer page);
    int DeleteUserById(Object[] objects);
    int AddUser(Object[] objects);
    int ResetPassword(Object[] objects);
    int UpdateUser(Object[] objects);
    List<User> ShowUser(Object[] objects);
    //int SelectPageSize();
    int SelectAllSize();
}


package com.qf.service;

import com.qf.entity.User;

import java.util.List;
import java.util.Objects;

public interface UserService {

    List<User> select(Integer page);

    int DeleteUserById(Object[] objects);
    int AddUser(Object[] objects);
    int ResetPassword(Object[] objects);
    int UpdateUser(Object[] objects);
    List<User> ShowUser(Object[] objects);
    int SelectLatest();//判断有多少页

}

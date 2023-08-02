package com.qf.service;

import com.qf.entity.User;

import java.util.List;

public interface UserService {
    List<User> fuzzyQueryAllUser(User user,int pageNo, int pageSize);
    int selectUserCount(User user);
    Boolean delUserById(int id);
    Boolean restPassword(int id);
    Boolean addUser(User user);
    User selectUserById(int id);
    Boolean updateUser(User user);
    List<User> selectUsersByName(String username);
}

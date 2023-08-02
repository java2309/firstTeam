package com.qf.dao;

import com.qf.entity.User;

import java.util.List;

public interface UserDao {
    List<User> queryAllUser(int pageNo, int pageSize);
    List<User> fuzzyQueryAllUserByName(String username,int pageNo, int pageSize);
    List<User> queryAllUserBySex(String sex,int pageNo, int pageSize);
    List<User> fuzzyQueryAllUserByNameAndSex(String username,String sex,int pageNo, int pageSize);
    int selectUserCount();
    int selectUserCountByName(String username);
    int selectUserCountBySex(String sex);
    int selectUserCountByNameAndSex(String username,String sex);
    int delUserById(int id);
    int restPassword(int id);
    int addUser(User user);
    User selectUserById(int id);
    int updateUser(User user);
    public List<User> selectUsersByName(String username);

}

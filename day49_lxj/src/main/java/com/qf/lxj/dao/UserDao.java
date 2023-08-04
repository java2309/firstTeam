package com.qf.lxj.dao;

import com.qf.lxj.entity.Student;

import java.util.List;

public interface UserDao {
    Integer login(String user,String password);
    List<Student> select(Integer page,Integer limit);
    Integer selectCount();
    Integer deleteById(Integer id);
    Integer update(String name ,String age,String info,String id);
    Integer add(String name ,String age,String info);
}

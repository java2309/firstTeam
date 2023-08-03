package com.qf.dao;

import com.qf.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    //先传个name，后面在传，做判断
    List<Teacher> login(String name);
}

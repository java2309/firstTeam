package com.sq.dao;

import com.sq.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> login(String name);
}

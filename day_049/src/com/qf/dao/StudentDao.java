package com.qf.dao;

import com.qf.entity.Student;

import java.util.List;

public interface StudentDao {
    int addStu(Object[] objs);
    int delStu(Integer id);
    int update(Object[] objs);
    int selectSizeByName(String name);
    List<Student> selectAllStudentByName(String name, Integer limit, Integer pageSize);
}

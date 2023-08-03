package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

public interface StudentService {
    int addStu(Object[] objs);
    int delStu(Integer id);
    int update(Object[] objs);

    List<Student> getAllStudent(String name, Integer limit, Integer pageSize);
    int selectSizeByName(String name);
}

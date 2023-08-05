package com.sq.dao;

import com.sq.pojo.Student;

public interface StudentDao {
    //通过id查询学生以及对应的课程
    Student findById(Integer id);
}

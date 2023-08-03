package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

/**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */
public interface StudentService {
     int addStu(Object[] objs);

    List<Student> getAllStudent(String name);
}

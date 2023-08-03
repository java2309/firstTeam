package com.qf.dao;

import com.qf.entity.Teacher;

import java.util.List;

/**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */
public interface TeacherDao {
    List<Teacher> login(String name);
}

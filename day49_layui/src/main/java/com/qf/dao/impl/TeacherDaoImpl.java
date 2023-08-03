package com.qf.dao.impl;

import com.qf.dao.TeacherDao;
import com.qf.entity.Teacher;
import com.qf.utils.BaseDao;

import java.util.List;

/**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */
public class TeacherDaoImpl extends BaseDao implements TeacherDao {
    @Override
    public List<Teacher> login(String name) {
        String sql = "select * from teacher where name = ?";
        Object[] objs = {name};
        List<Teacher> teachers = super.query(sql, objs, Teacher.class);
        return teachers;
    }
}

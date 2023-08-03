package com.sq.dao.Impl;

import com.sq.dao.TeacherDao;
import com.sq.entity.Teacher;
import com.sq.utils.BaseDao;

import java.util.List;

public class LoginDaoImpl extends BaseDao implements TeacherDao {
    @Override
    public List<Teacher> login(String name) {
        String sql = "select * from teacher where name = ?";
        Object[] obj = {name};
        List<Teacher> query = super.query(sql, obj, Teacher.class);
        return query;
    }
}

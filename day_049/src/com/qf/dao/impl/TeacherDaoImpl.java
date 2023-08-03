package com.qf.dao.impl;

import com.qf.dao.TeacherDao;
import com.qf.entity.Teacher;
import utils.BaseDao;

import java.util.List;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {

    @Override
    public List<Teacher> login(String name) {
        //验证账号的
        String sql = "select * from teacher where name = ?";
        Object[] objs = {name};
        List<Teacher> query = super.query(sql, objs,Teacher.class);
        return query;
    }
}

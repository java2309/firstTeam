package com.qf.dao.impl;

import com.qf.dao.AdminDao;
import com.qf.entity.Admin;
import com.qf.util.BaseDao;

import java.util.List;

public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public List<Admin> selectByName(String username) {
        String sql = "select * from admin where username = ?";
        Object[] objects = {username};
        List<Admin> admins = super.query(sql, objects, Admin.class);
        return admins;
    }
}

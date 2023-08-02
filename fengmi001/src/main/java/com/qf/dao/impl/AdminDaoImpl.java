package com.qf.dao.impl;

import com.qf.dao.AdminDao;
import com.qf.entity.Admin;
import com.qf.utils.BaseDao;

import java.util.List;

public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public List<Admin> selectAdminByName(String username) {
        String sql="select * from admin where username=?";
        Object [] objects={username};
        return super.query(sql,objects, Admin.class);
    }
}

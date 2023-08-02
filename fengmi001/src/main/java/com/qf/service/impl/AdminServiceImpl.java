package com.qf.service.impl;

import com.qf.dao.impl.AdminDaoImpl;
import com.qf.entity.Admin;
import com.qf.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Override
    public Boolean login(String username, String password) {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        List<Admin> list = adminDao.selectAdminByName(username);
        if (list==null){
            return false;
        }else {
            return password.equals(list.get(0).getPassword());
        }
    }
}

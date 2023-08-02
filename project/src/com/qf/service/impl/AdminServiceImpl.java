package com.qf.service.impl;

import com.qf.dao.AdminDao;
import com.qf.dao.impl.AdminDaoImpl;
import com.qf.entity.Admin;
import com.qf.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public boolean login(String username, String password) {
        List<Admin> admins = adminDao.selectByName(username);
        if (admins == null){
            //等于null用户不会存在
            return false;
        }else {
            if(password.equals(admins.get(0).getPassword())){
                return true;
            }else {
                return false;
            }
        }

    }
}

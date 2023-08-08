package com.sq.service.impl;

import com.sq.dao.UserDao;
import com.sq.pojo.User;
import com.sq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
    return userDao.findAll();
    }

}

package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.entity.User;
import com.qf.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> select(Integer page) {
        List<User> users = userDao.select(page);
        return users;
    }

    @Override
    public int DeleteUserById(Object[] objects) {
        int id = userDao.DeleteUserById(objects);
        return id;
    }

    @Override
    public int AddUser(Object[] objects) {
        int i = userDao.AddUser(objects);
        return i;
    }
    public int ResetPassword(Object[] objects){
        int pwd = userDao.ResetPassword(objects);
        return pwd;

    }
    public int UpdateUser(Object[] objects){
        int updateUser = userDao.UpdateUser(objects);
        return updateUser;
    }
    public List<User> ShowUser(Object[] objects){
        List<User> users = userDao.ShowUser(objects);
        return users;
    }

    @Override
    public int SelectLatest() {
        int size = userDao.SelectAllSize();
        int page = size/5;
        if (size%5 == 0) {
            return page;
        }
          return page+1;
    }


}

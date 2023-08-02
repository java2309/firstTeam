package com.qf.service.impl;

import com.qf.dao.impl.UserDaoImpl;
import com.qf.entity.User;
import com.qf.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public List<User> fuzzyQueryAllUser(User user,int pageNo, int pageSize) {
        if (user.getUsername()!=null&&user.getSex()!=null){
            return userDao.fuzzyQueryAllUserByNameAndSex(user.getUsername(), user.getSex(), pageNo,pageSize);
        }else if(user.getUsername()!=null&&user.getSex()==null){
            return userDao.fuzzyQueryAllUserByName(user.getUsername(), pageNo,pageSize);
        }else if (user.getUsername()==null&&user.getSex()!=null){
            return userDao.queryAllUserBySex(user.getSex(), pageNo,pageSize);
        }else {
            return userDao.queryAllUser(pageNo, pageSize);
        }
    }

    @Override
    public int selectUserCount(User user) {
        if (user.getUsername()!=null&&user.getSex()!=null){
            return userDao.selectUserCountByNameAndSex(user.getUsername(), user.getSex());
        }else if(user.getUsername()!=null&&user.getSex()==null){
            return userDao.selectUserCountByName(user.getUsername());
        }else if (user.getUsername()==null&&user.getSex()!=null){
            return userDao.selectUserCountBySex(user.getSex());
        }else {
            return userDao.selectUserCount();
        }
    }

    @Override
    public Boolean delUserById(int id) {
        return userDao.delUserById(id)==1;
    }

    @Override
    public Boolean restPassword(int id) {
        return userDao.restPassword(id)==1;
    }

    @Override
    public Boolean addUser(User user) {
        if (userDao.selectUsersByName(user.getUsername())==null){
            return userDao.addUser(user)==1;
        }else {
            return null;
        }

    }

    @Override
    public User selectUserById(int id) {
        return userDao.selectUserById(id);
    }

    @Override
    public Boolean updateUser(User user) {
        return userDao.updateUser(user)==1;
    }

    @Override
    public List<User> selectUsersByName(String username) {
        return userDao.selectUsersByName(username);
    }
}

package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


//@Component//去new UserServiceImpl（）  放到spring容器中
//service层专门的注解，把对象存到spring中
@Service
public class UserServiceImpl implements UserService {
    @Autowired//注入  将new UserDaoImpl 赋值给userDao这个变量，大多数都是这个
    @Qualifier(value = "userDaoImpl1")//配合前者一起使用的，针对某一个有名的
    //@Resource(name = "ud")，这个不用
    UserDao userDao;//咱用dao层的对象，好调方法
    @Override
    public void addUser() {
        userDao.addUser();
    }
}

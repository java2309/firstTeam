package com.sq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sq.pojo.User;
import com.sq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    public UserService userService;
    public List<User> findAll(){
        return userService.findAll();
    }

    public PageInfo<User> findByPage(Integer pageNum, Integer pageSize){

        PageHelper.startPage(pageNum,pageSize);

        List<User> userList = userService.findAll();

        PageInfo<User> userPageInfo = new PageInfo<>(userList);

        return userPageInfo;
    }
}

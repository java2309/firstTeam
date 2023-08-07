package com.qf.controller;

import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


//@Component
//老规矩，专门对controller的，到spring中
@Controller
public class UserController {
    //用service的方法
    @Autowired
    UserService userService;
    public void addControllerUser() {
        userService.addUser();
    }
}

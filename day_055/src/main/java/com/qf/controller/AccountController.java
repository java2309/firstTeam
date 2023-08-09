package com.qf.controller;

import com.qf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//要实例化
@Controller
public class AccountController {
    //先注入
    @Autowired
    AccountService accountService;
    //形参
    public void transfer(Integer fromId, Integer toId, Double money){
        accountService.transfer(fromId,toId,money);
    }
}


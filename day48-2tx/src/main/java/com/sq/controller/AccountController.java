package com.sq.controller;

import com.sq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {
    @Autowired
private AccountService accountService;

    public void transfer(Integer fromtId,Integer toId,Double money){
        accountService.transfer(fromtId,toId,money);
    }
}

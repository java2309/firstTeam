package com.qf.service;

public interface AccountService {
    //dao层里的方法，总的来说就是转账,这里面还是形参
    void transfer(Integer fromId, Integer toId, Double money);
}

package com.sq.service.impl;

import com.sq.mapper.AccountMapper;
import com.sq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public void transfer(Integer fromId, Integer toId, Double money) {
        //从账户转出
        accountMapper.outMoney(fromId,money);

        //手动模拟异常
        //int i = 1/0;

        //转入账户
        accountMapper.inMoney(toId,money);
    }
}

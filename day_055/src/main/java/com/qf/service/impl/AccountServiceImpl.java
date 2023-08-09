package com.qf.service.impl;

import com.qf.dao.AccountDao;
import com.qf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//也是要控制反转的，实例化对象
@Service
public class AccountServiceImpl implements AccountService {
    //先注入dao层的实例化的对象，二者是有关联的
    @Autowired
    AccountDao accountDao;
    //事务操作一般都在service层
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void transfer(Integer fromId, Integer toId, Double money) {
        //就是通过对象调方法了
        accountDao.outMoney(fromId,money);
        //int i = 10/0;
        accountDao.inMoney(toId,money);
    }
}

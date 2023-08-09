package com.qf.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {
   //写方法的，在与其映射的里面写sql语句，是核心,要跟映射的对应好
    void outMoney(@Param("fromId") Integer id, @Param("money") Double money);
    void inMoney(@Param("toId") Integer id, @Param("money") Double money);
}

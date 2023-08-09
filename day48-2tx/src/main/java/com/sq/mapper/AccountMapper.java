package com.sq.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    //转出
    void outMoney(@Param("fromId") Integer fromId, @Param("money") Double money);
    //转入
    void inMoney(@Param("toId") Integer toId, @Param("money") Double money);
}

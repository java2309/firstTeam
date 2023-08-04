package com.qf;

import com.qf.dao.UserDao;
import com.qf.entity.Passenger;
import com.qf.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestUserDao {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<Passenger> passengers = mapper.selectById(1);

        System.out.println(passengers);
    }
}

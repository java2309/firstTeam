package com.sq.util;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

//考虑问题：多个用户获取SqlSession对象时，线程安全问题
public class MybatisUtil {
    //声明SqlSessionFactory
    private static  SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession = null;

    //ThreadLocal线程副本：给每个线程创建变量副本，用于保证一个线程对某个变量的修改不会影响其他线程对该变量的使用，主要是线程安全情况

    //实例化SqlSessionFactory
    static {
        try {
            //读取主配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            //实例化
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    //获取SqlSession对象
    public static SqlSession getSqlSession(){
        //获取sqlSession
        //判断
        if (sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();

        }
        return sqlSession;
    }
    //关闭
    public static void close(){
        //获取sqlSession
        if (sqlSession != null){
            sqlSession.close();
        }
    }
    //提交事务
    public static void commit(){
        getSqlSession().commit();
        close();
    }
    //回滚事务
    public static void rollback(){
        getSqlSession().rollback();
        close();
    }
}

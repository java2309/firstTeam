package com.qf.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

//考虑问题：多个用户获取SqlSession对象时，线程安全问题
public class MybatisUtil {

    //声明SqlSessionFactory
    private static SqlSessionFactory sqlSessionFactory;
    private static  SqlSession sqlSession = null;

    //ThreadLocal线程副本：给每个线程创建变量副本，用于保证一个线程对某个变量的修改不会影响其他线程对该变量的使用，主要是线程安全情况
    //ThreadLocal  博客
    //private static final ThreadLocal<SqlSession> THREAD_LOCAL = new ThreadLocal<SqlSession>();

    //实例化SqlSessionFactory
    static {//静态代码块

        try {
            //读取主配置文件
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            //实例化
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);

        } catch (IOException e) {
            e.printStackTrace();//显示到控制台
        }
    }

    //获取SqlSession对象
    public static  SqlSession getSqlSession(){
        //获取sqlSession
        //SqlSession sqlSession = THREAD_LOCAL.get();

        //判断
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            //设置当前线程副本中的值
            //THREAD_LOCAL.set(sqlSession);
        }
        return sqlSession;
    }

    //关闭
    public static void close(){
        //获取sqlSession
        //SqlSession sqlSession = THREAD_LOCAL.get();

        if(sqlSession!=null){
            sqlSession.close();
            //删除当前线程副本中的值，为了防止内存溢出（OOM）和内存泄漏而导致程序报错
            //THREAD_LOCAL.remove();
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
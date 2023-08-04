package com.qf.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static final ThreadLocal<SqlSession> THREAD_LOCAL=new ThreadLocal<SqlSession>();
    static {
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
        SqlSession sqlSession = THREAD_LOCAL.get();
        //判断
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            //设置当前线程副本中的值
            THREAD_LOCAL.set(sqlSession);
        }
        return sqlSession;
    }
    //关闭
    public static void close(){
        //获取sqlSession
        SqlSession sqlSession = THREAD_LOCAL.get();
        if(sqlSession!=null){
            sqlSession.close();
            //删除当前线程副本中的值，为了防止内存溢出（OOM）和内存泄漏而导致程序报错
            THREAD_LOCAL.remove();
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

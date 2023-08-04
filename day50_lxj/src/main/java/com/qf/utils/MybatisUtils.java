package com.qf.utils;

import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;


/**
 * @author 86185
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession = null;

    static {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("Mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        if (sqlSession==null) {
            sqlSession = sqlSessionFactory.openSession();
        }
        return sqlSession;
    }

    public static void close(){
        if (sqlSession!=null) {
            getSqlSession().close();
        }
    }
    public static void commit(){
        getSqlSession().commit();
        close();
    }
}

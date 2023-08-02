package com.qf.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;

import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static DataSource dataSource = null;
    //只要类一加载就立马执行静态代码块
    static {
        //1.创建properties对象
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\IdeaWork\\project\\src\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //获取connection对象的方法
    public static Connection getConnection () {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //封装close方法
    //resultSet.close();
    //statment.close();
    //connection.close();
    public static void close (Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close (Statement statement, Connection connection) {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void close (ResultSet resultSet, Statement statement, Connection connection) {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

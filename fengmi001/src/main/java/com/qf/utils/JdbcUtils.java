package com.qf.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    private static DataSource dataSource=null;
    static {
        Properties properties=new Properties();
        try {
            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    获取connection对象的方法
    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection= dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

//    封装close方法
    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement statement,Connection connection){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

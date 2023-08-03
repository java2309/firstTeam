package com.ybbb.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbcutil {
    private static DataSource dataSource =null;
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\IdeaWork\\ajax_8\\src\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static Connection getconnection(){
        Connection connection=null;
            try {
                connection= dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
        public static void close(Connection connection){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }public static void close(Statement statement, Connection connection){
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }public static void close(ResultSet resultSet, Statement statement,Connection connection){
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

}

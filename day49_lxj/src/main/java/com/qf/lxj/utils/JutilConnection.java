package com.qf.lxj.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import java.sql.Connection;
import java.util.Properties;

public class JutilConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            connection = DruidDataSourceFactory.createDataSource(properties).getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

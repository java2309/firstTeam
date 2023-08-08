package com.qf.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

@PropertySource(value = "classpath:db.properties")
@Configuration
public class DataSourceConfig {

    @Value("${db.driver}")
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean("dataSource")
    public DataSource getDataSource(){

        Properties pro = new Properties();
        pro.setProperty("url",url);
        pro.setProperty("username",username);
        pro.setProperty("password",password);
        pro.setProperty("driverClassName",driverClassName);

        DataSource dataSource = null;

        try {
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;

    }
}
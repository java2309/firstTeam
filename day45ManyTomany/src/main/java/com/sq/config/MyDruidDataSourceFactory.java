package com.sq.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

public class MyDruidDataSourceFactory extends PooledDataSourceFactory {
    public MyDruidDataSourceFactory(){
        //替换数据源
        this.dataSource = new DruidDataSource();
    }
}

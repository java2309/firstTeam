package com.qf.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */
public class MyDruidDataSourceFactory extends PooledDataSourceFactory {
    public MyDruidDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }
}

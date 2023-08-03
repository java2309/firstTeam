package com.qf.utils;


import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    public int createtable(String sql) {
        Connection connection = Jdbcutil.getconnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbcutil.close(preparedStatement, connection);
        }
        return 0;
    }
    //创建表的方法
    public int insert(String sql, Object[] parametrers) {
        Connection connection = Jdbcutil.getconnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
            if (parametrers != null && parameterCount == parametrers.length) {
                for (int i = 0; i < parametrers.length; i++) {
                    preparedStatement.setObject(i + 1, parametrers[i]);
                }
                return preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbcutil.close(preparedStatement, connection);
        }
        return 0;
    }
    //增删改的方法
    public int update(String sql, Object[] parametrers) {
        Connection connection = Jdbcutil.getconnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
            if (parametrers != null && parameterCount == parametrers.length) {
                for (int i = 0; i < parametrers.length; i++) {
                    preparedStatement.setObject(i + 1, parametrers[i]);
                }
                return preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbcutil.close(preparedStatement, connection);
        }
        return 0;
    }
    //查询的方法
     public <T>List<T> query(String sql, Object[] paraments, Class<T> cls) {
        Connection connection = Jdbcutil.getconnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list=null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
            if (paraments != null && parameterCount == paraments.length) {
                for (int i = 0; i < paraments.length; i++) {
                    preparedStatement.setObject(i + 1, paraments[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
            list=new ArrayList<>();
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                T t = cls.getConstructor(null).newInstance(null);
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnName(i + 1);
                    Object value = resultSet.getObject(columnName);
                    BeanUtils.setProperty(t, columnName, value);
                }
                list.add(t);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Jdbcutil.close(resultSet, preparedStatement,connection);
        }
        return list.size()!=0?list:null;
    }
    //模糊查询总条数的方法
    public int selectCount(Object[] params,String sql) {
//1.连接数据库
        Connection connection = Jdbcutil.getconnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            int parameterCount = parameterMetaData.getParameterCount();
            if (params != null && params.length == parameterCount) {
                for (int i = 0; i < parameterCount; i++) {
                    preparedStatement.setObject(i+1, params[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Jdbcutil.close(resultSet, preparedStatement, connection);
        }
        return 0;
    }
//模糊查询总条数
public int selectAllCount(String sql) {
    Connection connection = Jdbcutil.getconnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt("count(*)");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        Jdbcutil.close(resultSet, preparedStatement,connection);
    }
    return 0;
}

}




package com.qf.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    public int selectCount(String sql){
        Connection connection=JdbcUtils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        int value=0;
        try {
            preparedStatement= connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                value = resultSet.getInt("count(*)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                JdbcUtils.close(resultSet,preparedStatement,connection);
            }
        }
        return value;
    }
    public int update(String sql,Object[] parameters){
        Connection connection=JdbcUtils.getConnection();
        PreparedStatement preparedStatement=null;

        try {
            preparedStatement= connection.prepareStatement(sql);

            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();

            if (parameters!=null&&parameterCount==parameters.length){
                for (int i=1;i<=parameterCount;i++){
                    preparedStatement.setObject(i,parameters[i-1]);
                }
                int i;
                i = preparedStatement.executeUpdate();
                return i;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null) {
                JdbcUtils.close(preparedStatement,connection);
            }
        }
        return 0;
    }

    public <T> List<T> query(String sql,Object[] parameters,Class<T> cls){
        Connection connection=JdbcUtils.getConnection();

        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<T> list=null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
            if (parameters!=null&&parameterCount==parameters.length){
                for (int i=1;i<=parameterCount;i++){
                    preparedStatement.setObject(i,parameters[i-1]);


                }
            }
            resultSet=preparedStatement.executeQuery();
            list=new ArrayList<>();

            ResultSetMetaData metaData=resultSet.getMetaData();
            int columnCount=metaData.getColumnCount();
            while (resultSet.next()){
                T t=cls.getConstructor(null).newInstance(null);
                for (int i=1;i<=columnCount;i++){
                    String columnName=metaData.getColumnName(i);
                    Object value=resultSet.getObject(columnName);

                    BeanUtils.setProperty(t,columnName,value);
                }
                list.add(t);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                JdbcUtils.close(resultSet,preparedStatement,connection);
            }
        }
        if (list != null) {
            return list.size() != 0 ? list:null;
        }
        return null;
    }

}

package com.qf.lxj.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BaseDao implements Serializable {
    static Connection connection = JutilConnection.getConnection();

    public static int update(String sql, Object[] obj) {
        Integer result = null;
        //使用JDK1.7的新特性自动关闭资源
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            //获取传入预处理的sql语句中需要处理的参数的个数
            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
            //通过for循环来设置参数
            //通过if判断是否可以传参数
            if (obj != null && parameterCount == obj.length) {
                for (int i = 0; i < parameterCount; i++) {
                    preparedStatement.setObject(i + 1, obj[i]);
                }
            }
            //通过预处理的搬运工对象来执行语句
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回参数判断是否执行成功
        return result;
    }

    public static <T> List<T> query(String sql, Object[] obj, Class<T> cls) {
        List<T> list = new ArrayList<>();
        //通过JDK1.7的新特性来自动关闭资源
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            //获取预处理的sql语句中参数的数量
            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
            //通过for循环来给参数赋值
            //先判断是否参数数量和obj中的参数数量相等
            if (obj != null && parameterCount == obj.length) {
                for (int i = 0; i < parameterCount; i++) {
                    preparedStatement.setObject(i + 1, obj[i]);
                }
            }
            //通过预处理的搬运工对象运行代码
            ResultSet resultSet = preparedStatement.executeQuery();
            //通过getMetaData()方法获取结果集中字段的数量
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            //通过while循环遍历结果集中的数据
            while (resultSet.next()) {
                //通过反射获取传入的Class对象的类对象
                T t = cls.getConstructor().newInstance();
                //借助metadata通过for循环遍历字段并获取字段的名字
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnName(i + 1);
                    Object object = resultSet.getObject(columnName);
                    //通过BeanUtils设置传入的类对象的值
                    BeanUtils.setProperty(t, columnName, object);
                }
                //将设置好值的对象存入list集合中
                list.add(t);
            }
            //关闭结果集
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将list集合作为返回值返回出去
        return list.size() != 0 ? list : null;
    }

    public static Integer querySize(String sql) {
        Integer size = null;
        //通过JDK1.7的新特性来自动关闭资源
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            //通过预处理的搬运工对象运行代码
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                size = resultSet.getInt(1);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将list集合作为返回值返回出去
        return size;
    }
}

package com.qf.utils;


import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */
public class BaseDao {

    /**
     * 完成一个统一的增删改的方法
     * @param sql   参数化的sql String sql =  insert into work(name, age, info) values(?,?,?)
     * @param parameters  Object[] objs = {"嘻嘻", 12, "数据"};
     *                    对象.update(sql, objs);
     * @return
     */
    public int update(String sql, Object[] parameters) {
        //1.获取连接数据库的对象
        Connection connection = JdbcUtil.getConnection();
        //2.获取预处理的对象搬运工对象
        PreparedStatement preparedStatement = null;
        try {
           preparedStatement = connection.prepareStatement(sql);
            //3.获取参数元数据，并使用对象获取参数的个数
            //为啥要获取参数的个数？为了对?赋值
            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();

            //4.开始对? 进行赋值
            if (parameters != null && parameterCount == parameters.length) {
                for (int i = 0; i < parameterCount; i++) {
                    preparedStatement.setObject(i + 1, parameters[i]);
                }
            }

            //5.整真正的执行sql的增删改的方法
            int i = preparedStatement.executeUpdate();
            return i;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            JdbcUtil.close(preparedStatement, connection);
        }
        return 0;
    }
    /**
     * 完成一个统一的查询的方法
     *  1.方法的名字叫啥  query
     *  2.方法的返回值是啥   List<T>
     *  3.方法的参数的是啥  String sql, Object[] parameters, Class<T> cls
     *
     *  String sql = "select * from work where id  =?"
     *  Object[] objs = {6};
     *  查询出来以后，将数据赋值给一个对象work，然后把对象存到集合
     *   *  String sql = "select * from person "
     *      *  Object[] objs = null;
     *      *  查询出来以后，将数据赋值给一个对象person，然后把对象存到集合
     *
     *      query（sql， objs， Work.class）    Work.class  实参！！！
     *      将Work.class这个Class对象转为Work对象
     */
    public <T> List<T> query (String sql, Object[] parameters, Class<T> cls) {
        //1.连接数据库获取数据库对象
        Connection connection = JdbcUtil.getConnection();
        //2.获取预处理的搬运工对象
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = null;
        try {
           preparedStatement = connection.prepareStatement(sql);
            //3.去处理sql语句中的参数?  获取参数元数据对象，然后拿对象获取参数的个数
            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();

            //4.开始对? 进行赋值  没有?  就不再进入if语句了
            if (parameters != null && parameterCount == parameters.length) {
                for (int i = 0; i < parameterCount; i++) {
                    preparedStatement.setObject(i + 1, parameters[i]);
                }
            }
            //5.执行查询sql语句，但是查询的和增删改 不一样，因为查询会返回结果集
           resultSet = preparedStatement.executeQuery();
            //6.创建一个List集合
            list =  new ArrayList<>();
            /**
             * 想象咱们的resultSet  就是如下的东西
             * id name age info
             * 1  狗蛋  12  数据
             * 2  嘻嘻  28 十多年
             * 3  永杰  38 文件
             */
            //7.获取结果集元数据对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            //8.通过结果集元数据对象获取列的个数   知道有几列数据
            int columnCount = metaData.getColumnCount();
            //9.遍历结果集
            while (resultSet.next()) {//控制行
                //10.通过第三个参数 Class对象实例化当前对象 Work.class===>new Work()
                T t = cls.getConstructor(null).newInstance(null);

                for (int i = 1; i <= columnCount; i++) {//控制列
                    //11.获取列的名字
                    String columnName = metaData.getColumnName(i);
                    //System.out.print(columnName + "\t");
                    //12.通过字段获取当前行数据的值
                    Object value = resultSet.getObject(columnName);
                    //System.out.print(value +"\t");
                    //13.出来数据用对象来接数据
                    //Work work = new Work();这样写死了，要借助于反射
                    //这个对象的属性进行赋值的，因为上面有字段的名字获取的，很巧妙！！！
                    //刚好借用字段的名字给属性赋值,所以保证字段名字和对应的实体类中的De属性一样
                    BeanUtils.setProperty(t, columnName, value);
                    //t就有值了

                }
                //14.把t存到list集合中
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(resultSet, preparedStatement, connection);
        }
        //来判断list集合中是否有数据，如果有返回list 如果没有返回null
    return list.size() != 0 ? list : null;

    }

    //查询总条数的方法  seletc cunt(*) from e
    public int querySize(String sql) {
        //1.连接数据库
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            /**
             * count(*)
             * 78
             */
            while (resultSet.next()) {
                int anInt = resultSet.getInt("count(*)");
                return anInt;//查询的总条数
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet, preparedStatement, connection);
        }
    return 0;
    }

}

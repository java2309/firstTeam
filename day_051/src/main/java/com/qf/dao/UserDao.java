package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
//   查询所有用户
    List<User> findAll();
    //查询单个用户
    //如果方法中只有一个参数，对应的#{}中的名称可以任意，也可使用@Param注解指定#{}中的名称

    User findById(Integer id);

    //增加用户，如果传递的是对象，对应的#{}中的名称要和传递对象的属性名称一致
    void addUser(User user);

    //修改用户
    void updateUser(User user);

    //通过id删除用户
    void deleteUserById(Integer id);

    //三种类型的模糊查询
    List<User> findByName1(String name);
    List<User> findByName2(String name);
    List<User> findByName3(String name);

    //获取总记录数
    Integer getTotalCount();

    //分页查询，如果方法中有多个参数，必须使用@Param注解，名称必须和#{}中的名称一致
    //注解括号里的要对应，后面的是形参
    List<User> getPageData(@Param("first") Integer first, @Param("second")Integer second);

    //查询所有用户
    List<User> findAll1();
}

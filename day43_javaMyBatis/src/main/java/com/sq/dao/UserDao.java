package com.sq.dao;

import com.sq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> findAllUser();
    //查询单个用户
    User findById(Integer id);
    /**
     * 添加用户
     * @param user
     *
     * 如果传递的是对象，对应的#{}中的名称要和传递对象的属性名称一致
     */
    void addUser(User user);
    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);
    /**
     * 通过id删除用户
     * @param id
     */
    void deleteUserById(Integer id);
    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<User> findByName1(String name);
    List<User> findByName2(String name);
    List<User> findByName3(String name);
    /**
     * 获取总记录数
     * @return
     */
    Integer getTotalCount();
    /**
     * 分页查询
     * @param first
     * @param second
     * @return
     *
     * 如果方法中有多个参数，必须使用@Param注解，名称必须和#{}中的名称一致
     */
    List<User> findPageData(@Param("first") Integer first, @Param("second") Integer second);
}

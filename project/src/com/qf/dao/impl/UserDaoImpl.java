package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.util.BaseDao;

import java.util.List;
import java.util.Objects;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> select(Integer page) {//查询user表中的所有数据
        String sql = "select * from t_user limit "+(page-1)*5+","+5;
        List<User> users = super.query(sql, null, User.class);
        return users;
    }

    //删除user中的数据
    public int DeleteUserById(Object[] objects) {
        String sql = "delete from t_user where id = ?";
        return super.update(sql, objects);
    }

    //添加数据
    public int AddUser(Object[] objects) {
        String sql = "insert into t_user (username,password,phone,sex,mail)values(?,?,?,?,?)";
        return super.update(sql, objects);
    }

    //重置密码
    public int ResetPassword(Object[] objects) {
        String sql = "UPDATE t_user SET password = '123456' WHERE id = ?";
        return super.update(sql, objects);
    }

    //修改数据
    public int UpdateUser(Object[] objects) {
        String sql = "update t_user set username=?,password=?,phone=?,sex=?, mail=? where id=?";
        return super.update(sql, objects);
    }

    public List<User> ShowUser(Object[] objects) {//查询user表中的所有数据
        String sql = "select * from t_user where id = ?";
        List<User> users = super.query(sql, objects, User.class);
        return users;
    }

    @Override
    public int SelectAllSize() {
        String sql = "select count(*) from t_user";//查询所有的总条数
        int i = super.querySize(sql);
        return i;

    }

}

package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.utils.BaseDao;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public List<User> queryAllUser(int pageNo, int pageSize) {
        String sql="select * from t_user limit ?,?";
        Object[] objects={(pageNo-1)*pageSize,pageSize};
        return super.query(sql,objects, User.class);
    }
    @Override
    public List<User> fuzzyQueryAllUserByName(String username,int pageNo, int pageSize) {
        String sql="select * from t_user where username like '%"+username+"%' limit ?,?";
        Object[] objects={(pageNo-1)*pageSize,pageSize};
        return super.query(sql,objects, User.class);
    }

    @Override
    public List<User> queryAllUserBySex(String sex, int pageNo, int pageSize) {
        String sql="select * from t_user where sex = ? limit ?,?";
        Object[] objects={sex,(pageNo-1)*pageSize,pageSize};
        return super.query(sql,objects, User.class);
    }

    @Override
    public List<User> fuzzyQueryAllUserByNameAndSex(String username, String sex, int pageNo, int pageSize) {
        String sql="select * from t_user where username like '%"+username+"%' and sex = ? limit ?,?";
        Object[] objects={sex,(pageNo-1)*pageSize,pageSize};
        return super.query(sql,objects, User.class);
    }

    @Override
    public int selectUserCount() {
        String sql="select count(*) from t_user";
        return super.selectCount(sql);
    }

    @Override
    public int selectUserCountByName(String username) {
        String sql="select count(*) from t_user where username like '%"+username+"%'";

        return super.selectCount(sql);
    }

    @Override
    public int selectUserCountBySex(String sex) {
        String sql="select count(*) from t_user where sex = '"+sex+"'" ;

        return super.selectCount(sql);
    }

    @Override
    public int selectUserCountByNameAndSex(String username, String sex) {
        String sql="select count(*) from t_user where username like '%"+username+"%' and sex = '"+sex+"'";
        return super.selectCount(sql);
    }

    @Override
    public int delUserById(int id) {
        String sql="delete from t_user where id=?";
        Object[] objects={id};
        return super.update(sql,objects);
    }

    @Override
    public int restPassword(int id) {
        String sql="update t_user set password='000000' where id=?";
        Object[] objects={id};
        return super.update(sql,objects);
    }

    @Override
    public int addUser(User user) {
        String sql="insert into t_user (username,password,phone,mail) values (?,?,?,?)";
        Object[] objects={user.getUsername(),user.getPassword(),user.getPhone(),user.getMail()};
        return super.update(sql,objects);
    }

    @Override
    public User selectUserById(int id) {
        String sql="select * from t_user where id=?";
        Object[] objects={id};
        return super.query(sql,objects, User.class).get(0);
    }

    @Override
    public int updateUser(User user) {
        String sql="update t_user set username=?,password=?,phone=?,sex=?,mail=? where id=?";
        Object[] objects={user.getUsername(),user.getPassword(),user.getPhone(),user.getSex(),user.getMail(),user.getId()};
        return super.update(sql,objects);
    }

    @Override
    public List<User> selectUsersByName(String username) {
        String sql="select * from t_user where username like '%"+username+"%'";

        return super.query(sql,null, User.class);
    }


}

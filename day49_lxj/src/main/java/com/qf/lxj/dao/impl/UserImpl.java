package com.qf.lxj.dao.impl;

import com.qf.lxj.dao.UserDao;
import com.qf.lxj.entity.Student;
import com.qf.lxj.entity.Teacher;
import com.qf.lxj.utils.BaseDao;

import java.util.List;
import java.util.Random;

public class UserImpl implements UserDao {
    @Override
    public Integer login(String user, String password) {
        String sql = "select * from teacher where name = ?";
        Object[] obj = {user};
        List<Teacher> query = BaseDao.query(sql, obj, Teacher.class);
        if (query != null) {
            String password1 = query.get(0).getPassword();
            if (password.equals(password1)) {
                return 1;
            } else {
                return 3;
            }
        } else {
            return 2;
        }
    }

    @Override
    public List<Student> select(Integer page,Integer limit) {
        String sql = "select * from student limit " + (page - 1) * limit + "," + limit;
        return BaseDao.query(sql, null, Student.class);
    }

    @Override
    public Integer selectCount() {
        String sql = "select count(*) from student";
        return BaseDao.querySize(sql);
    }

    @Override
    public Integer deleteById(Integer id) {
        String sql = "delete from student where id = ?";
        Object[] objects = {id};
        return BaseDao.update(sql,objects);
    }

    @Override
    public Integer update(String name, String age, String info,String id) {
        String sql = "update student set stu_name = ? ,age = ?, info = ? where id = ?";
        Object[] objects = {name,age,info,id};
        return BaseDao.update(sql,objects);
    }

    @Override
    public Integer add(String name, String age, String info) {
        String sql = "insert into student(stu_name,age,info) values(?,?,?)";
        Object[] objects={name,age,info};
        return BaseDao.update(sql,objects);
    }
}

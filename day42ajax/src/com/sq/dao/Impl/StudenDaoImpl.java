package com.sq.dao.Impl;

import com.sq.dao.StudenDao;
import com.sq.entity.Studen;
import com.sq.utils.BaseDao;

import java.util.List;

public class StudenDaoImpl extends BaseDao implements StudenDao {
    @Override
    public List<Studen> selectAllByName(String name,Integer limit,Integer pageSize) {
        String sql = "select s.id, s.stu_name, s.age, s.info from student s inner join teacher t on s.t_id = t.id where t.name=? limit ?,?";
        Object[] obj = {name,limit,pageSize};
        List<Studen> Students = super.query(sql, obj, Studen.class);

        return Students;
    }

    @Override
    public int delStu(Integer id) {
        String sql = "delete from student where id = ?";
        Object[] objs = {id};
        int update = super.update(sql, objs);
        return update;
    }

    @Override
    public int selectSizeByName(String name) {
        String sql = "select count(*) from student s inner join teacher t on s.t_id = t.id where t.name = '"+name+"'";
        int i = super.querySize(sql);
        return i;
    }

    @Override
    public int update(Object[] objs) {
        String sql = "update student set stu_name=?, age=?, info=? where id = ?";
        int update = super.update(sql, objs);
        return update;
    }

    @Override
    public int add(Object[] objs) {
        String sql = "insert into student(stu_name,age,info) values(?,?,?)";
        int update = super.update(sql, objs);
        return update;
    }
}

package com.qf.dao.impl;

import com.qf.dao.StudentDao;
import com.qf.entity.Student;
import utils.BaseDao;

import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {

    @Override
    public int addStu(Object[] objs) {
        String sql = "insert into student (stu_name,age,info) values(?,?,?)";
        return super.update(sql,objs);
    }

    @Override
    public int delStu(Integer id) {
        String sql = "delete from student where id = ?";
        Object[] objs = {id};
        int update = super.update(sql, objs);
        return update;
    }

    @Override
    public int update(Object[] objs) {
        String sql = "update student set stu_name=?, age=?, info=? where id = ?";
        int update = super.update(sql, objs);
        return update;
    }

    @Override
    public int selectSizeByName(String name) {
        String sql = "select count(*) from student s inner join teacher t on s.t_id = t.id where t.name = '" + name + "'";
        int i = super.querySize(sql);
        return i;
    }

    @Override
    public List<Student> selectAllStudentByName(String name, Integer limit, Integer pageSize) {
            String sql = "select s.id, s.stu_name, s.age, s.info from student s inner join teacher t on s.t_id = t.id where t.name = ?  limit ?, ?";
            Object[] objs = {name, limit, pageSize};
            List<Student> students = super.query(sql, objs, Student.class);

            return students;
    }
}

package com.qf.dao.impl;

import com.qf.dao.StudentDao;
import com.qf.entity.Student;
import com.qf.utils.BaseDao;

import java.util.List;

/**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */
public  class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public List<Student> selectAllStudentByName(String name) {
        String sql = "select s.id, s.stu_name, s.age, s.info \n" +
                "from student s\n" +
                "inner join teacher t\n" +
                "on s.t_id = t.id\n" +
                " where t.name = ?";
        Object[] objs = {name};
        List<Student> students = super.query(sql, objs, Student.class);

        return students;
    }

    @Override
    public int delStu(Integer id) {
        String sql = "delete from student where id = ?";
        Object[] objs = {id};
        int update = super.update(sql, objs);
        return update;
    }


    public int addStu(Object[] objs) {
        String sql = "insert into student(stu_name,age,info) values(?,?,?)";
        int update = super.update(sql, objs);
        return update;
    }

}

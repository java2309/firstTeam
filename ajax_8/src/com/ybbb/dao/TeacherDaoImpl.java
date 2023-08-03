package com.ybbb.dao;



import com.ybbb.pojo.Student;
import com.ybbb.pojo.Teacher;
import com.ybbb.utils.BaseDao;

import java.util.List;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {

    @Override
    public List<Teacher> selectUser(String name) {
        String sql = "select * from teacher where name=?";
        Object[] objs = {name};
        List<Teacher> query = super.query(sql, objs, Teacher.class);
        return query;
    }

    @Override
    public List<Student> selectStudent(Object[] objects) {
        String sql = "SELECT s.id, s.stu_name, s.age, s.sex, s.info FROM student s INNER JOIN teacher t ON s.t_id = t.id WHERE t.name = ? LIMIT ?, ?";

        List<Student> query = super.query(sql, objects, Student.class);
        return query;
    }

    @Override
    public int selectStudentCount(String name) {
        String sql = "SELECT count(*) FROM student s INNER JOIN teacher t ON s.t_id = t.id WHERE t.name = ?";
        Object[] objs = {name};
        int count = super.selectCount(objs,sql );
        return count;
    }

    @Override
    public int updateStudent(Object[] objects) {
        String sql = "update student set stu_name=?, age=?,sex=?,info=? where id=?";
        int update = super.update(sql, objects);
        return update;
    }

    @Override
    public int addStudent(Object[] objects) {
        String sql = "insert into student (stu_name,age,sex,info,t_id) values(?,?,?,?,?)";
        int update = super.update(sql, objects);
        return update;
    }

    @Override
    public int deleteStudent(Object[] objects) {
        String sql = "delete from student where id=?";
        int update = super.update(sql, objects);
        return update;
    }
}

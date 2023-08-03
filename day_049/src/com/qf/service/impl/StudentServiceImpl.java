package com.qf.service.impl;

import com.qf.dao.StudentDao;
import com.qf.dao.impl.StudentDaoImpl;
import com.qf.entity.Student;
import com.qf.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();


    @Override
    public int addStu(Object[] objs) {
        int i = studentDao.addStu(objs);
        return i;
    }

    @Override
    public int delStu(Integer id) {
        int i = studentDao.delStu(id);
        return i;
    }

    @Override
    public int update(Object[] objs) {
        int update = studentDao.update(objs);
        return update;
    }

    @Override
    public List<Student> getAllStudent(String name, Integer limit, Integer pageSize) {
        List<Student> students = studentDao.selectAllStudentByName(name, limit, pageSize);

        return students;
    }

    @Override
    public int selectSizeByName(String name) {
        int i = studentDao.selectSizeByName(name);
        return i;
    }
}

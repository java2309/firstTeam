package com.qf.service.impl;

import com.qf.dao.StudentDao;
import com.qf.dao.impl.StudentDaoImpl;
import com.qf.entity.Student;
import com.qf.service.StudentService;

import java.util.List;

/**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */
public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public int addStu(Object[] objs) {
        return StudentDao.addStu(objs);

    }

    @Override
    public List<Student> getAllStudent(String name) {
        List<Student> students = studentDao.selectAllStudentByName(name);

        return students;
    }
}

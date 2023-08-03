package com.ybbb.dao;



import com.ybbb.pojo.Student;
import com.ybbb.pojo.Teacher;

import java.util.List;

public interface TeacherDao {
    public List<Teacher> selectUser(String name);
    public List<Student> selectStudent(Object[] objects);
    int selectStudentCount(String name);
    int updateStudent(Object[] objects);
    int addStudent(Object[] objects);
    int deleteStudent(Object[] objects);
}

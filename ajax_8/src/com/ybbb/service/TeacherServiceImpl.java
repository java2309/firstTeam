package com.ybbb.service;



import com.ybbb.dao.TeacherDao;
import com.ybbb.dao.TeacherDaoImpl;
import com.ybbb.pojo.Teacher;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public int selectUser(String name, String password) {
        List<Teacher> teachers = teacherDao.selectUser(name);
        if (teachers != null) {
            String password1 = teachers.get(0).getPassword();
            if (password1.equals(password)) {
                return 1;//用户密码正确
            } else  {
                return 2;//密码错误
            }
        }
        else {
            return 3;//用户名错误
        }
    }
}
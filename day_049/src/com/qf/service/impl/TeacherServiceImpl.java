package com.qf.service.impl;

import com.qf.dao.TeacherDao;
import com.qf.dao.impl.TeacherDaoImpl;
import com.qf.entity.Teacher;
import com.qf.service.TeacherService;
import utils.BaseDao;

import java.util.List;

public class TeacherServiceImpl extends BaseDao implements TeacherService {
    TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public int login(String name, String password) {
        List<Teacher> login = teacherDao.login(name);
        if (login != null){
            Teacher teacher = login.get(0);
            if (teacher.getPassword().equals(password)){
                return 1;//全对
            }else {
                return 2;//密码错误
            }
        }else {
            return 3;//该用户名错误
        }
    }
}

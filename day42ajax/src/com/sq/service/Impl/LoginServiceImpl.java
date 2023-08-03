package com.sq.service.Impl;

import com.sq.dao.Impl.LoginDaoImpl;
import com.sq.dao.TeacherDao;
import com.sq.entity.Teacher;
import com.sq.service.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService {
    TeacherDao teacherDao = new LoginDaoImpl();
    @Override
    public int login(String name, String password) {
        List<Teacher> login = teacherDao.login(name);
        if (login != null){
            //再次判断密码
            Teacher teacher = login.get(0);
            if (teacher.getPassword().equals(password)){
                return 0;
            }else {
                //密码不对
                return 1;
            }
        }else {
            //用户不存在
            return 2;
        }
    }
}

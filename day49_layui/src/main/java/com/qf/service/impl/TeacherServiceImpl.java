package com.qf.service.impl;

import com.qf.dao.TeacherDao;
import com.qf.dao.impl.TeacherDaoImpl;
import com.qf.entity.Teacher;
import com.qf.service.TeacherService;

import java.util.List;

/**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */
public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public int login(String name, String password) {
        List<Teacher> login = teacherDao.login(name);//name就是input数据值
        if (login != null) {
             //有这个用户，再次判断密码
            Teacher teacher = login.get(0);

            if (teacher.getPassword().equals(password)) {
                return 1;
            } else {
                //密码不正确
                return 3;
            }
        } else {
            //没有此用户
            return 2;
        }

    }
}

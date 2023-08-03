package com.qf.controller;

import com.alibaba.fastjson.JSON;
import com.qf.dao.StudentDao;
import com.qf.dao.TeacherDao;
import com.qf.dao.impl.StudentDaoImpl;
import com.qf.dao.impl.TeacherDaoImpl;
import com.qf.entity.R;
import com.qf.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    StudentDao studentDao = new StudentDaoImpl();
    TeacherDao teacherDao=new TeacherDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String stu_name = request.getParameter("name");
        String age = request.getParameter("age");
        String info = request.getParameter("info");
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        List<Teacher> login = teacherDao.login((String) user);
        Integer id = login.get(0).getId();
        Object[] objs = {stu_name, age, info, id};
        int addStu = studentDao.addStu(objs);
        PrintWriter writer = response.getWriter();
        if (addStu == 1) {
            R r = new R();
            r.setCode(1);
            r.setMsg("添加成功");
            String s = JSON.toJSONString(r);
            writer.write(s);
        } else {
            R r = new R();
            r.setCode(0);
            r.setMsg("添加失败");
            String s = JSON.toJSONString(r);
            writer.write(s);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

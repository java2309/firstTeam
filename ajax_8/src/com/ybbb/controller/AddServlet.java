package com.ybbb.controller;


import com.alibaba.fastjson2.JSON;
import com.ybbb.dao.TeacherDao;
import com.ybbb.dao.TeacherDaoImpl;
import com.ybbb.pojo.R;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    TeacherDao studentDao = new TeacherDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Object id1 = session.getAttribute("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String info = request.getParameter("info");
        Object[] objects = {name,age,sex,info,id1};
        int i = studentDao.addStudent(objects);
        PrintWriter writer = response.getWriter();
        if (i == 1) {
            R r = new R();
            r.setCode(0);
            r.setMsg("添加成功");
            String s = JSON.toJSONString(r);
            writer.write(s);
        } else {
            R r = new R();
            r.setCode(1);
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
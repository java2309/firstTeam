package com.qf.controller;

import com.alibaba.fastjson.JSON;
import com.qf.dao.StudentDao;
import com.qf.dao.impl.StudentDaoImpl;
import com.qf.entity.R;
import com.qf.service.StudentService;
import com.qf.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        String stuName = request.getParameter("stu_name");
        String age = request.getParameter("age");
        String info = request.getParameter("info");

        Object[] objects = {stuName,age,info};
        int i = StudentDao.addStu(objects);
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

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

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    TeacherDao studentDao = new TeacherDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String stu_name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String info = request.getParameter("info");
        Object[] objs = {stu_name, age,sex, info, id};
        int update = studentDao.updateStudent(objs);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (update == 1) {
            R r = new R();
            r.setCode(1);
            r.setMsg("修改成功");
            String s = JSON.toJSONString(r);
            writer.write(s);
        } else {
            R r = new R();
            r.setCode(0);
            r.setMsg("修改失败");
            String s = JSON.toJSONString(r);
            writer.write(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    TeacherDao studentDao = new TeacherDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        Object[] objects = {id};
        int i = studentDao.deleteStudent(objects);
        PrintWriter writer = response.getWriter();
        if (i == 1) {
            R r = new R();
            r.setCode(1);
            r.setMsg("删除成功");
            String s = JSON.toJSONString(r);
            writer.write(s);
        } else {
            R r = new R();
            r.setCode(0);
            r.setMsg("删除失败");
            String s = JSON.toJSONString(r);
            writer.write(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
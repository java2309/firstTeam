package com.qf.lxj.controller;

import com.alibaba.fastjson.JSON;
import com.qf.lxj.dao.UserDao;
import com.qf.lxj.dao.impl.UserImpl;
import com.qf.lxj.entity.Student;
import com.qf.lxj.utils.BaseDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserDao userDao = new UserImpl();
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        List<Student> students = userDao.select(Integer.parseInt(page),Integer.parseInt(limit));
        String data = JSON.toJSONString(students);
        PrintWriter writer = response.getWriter();
        writer.write("{\"code\":0,\"msg\":0,\"count\":"+userDao.selectCount()+",\"data\":"+data+"}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

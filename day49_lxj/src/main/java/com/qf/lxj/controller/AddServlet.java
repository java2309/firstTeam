package com.qf.lxj.controller;

import com.qf.lxj.dao.UserDao;
import com.qf.lxj.dao.impl.UserImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String info = request.getParameter("info");
        UserDao userDao = new UserImpl();
        Integer update = userDao.add(name, age, info);
        PrintWriter writer = response.getWriter();
        if (update==1){
            writer.write("true");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

package com.qf.lxj.controller;

import com.qf.lxj.dao.UserDao;
import com.qf.lxj.dao.impl.UserImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserImpl();
        Integer delete = userDao.deleteById(id);
        PrintWriter writer = response.getWriter();
        if (delete==1){
            writer.write("true");
        }else {
            writer.write("error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

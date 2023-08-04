package com.qf.lxj.controller;

import com.qf.lxj.dao.UserDao;
import com.qf.lxj.dao.impl.UserImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        UserDao userDao = new UserImpl();
        Integer login = userDao.login(user, password);
        PrintWriter writer = response.getWriter();
        if (login == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("password", password);
            writer.write("{\"code\":1}");
        } else if (login == 2) {
            writer.write("{\"code\":2}");
        } else if (login == 3){
            writer.write("{\"code\":3}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

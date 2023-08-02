package com.qf.contoller;

import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "UserAddServlet", value = "/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String mail = request.getParameter("mail");
       Object[] objects = {username,password,phone,sex,mail};
        int i = userService.AddUser(objects);
        System.out.println(i);
        if (i == 1) {
            response.sendRedirect("UserFuzzyServlet");
        }else if (i == 0){
            PrintWriter writer = response.getWriter();
            writer.print("<script>alert('添加失败');window.location.href ='UserFuzzyServlet';</script>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

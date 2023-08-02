package com.qf.contoller;

import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserUpdateServlet", value = "/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String mail = request.getParameter("mail");
        Object[] objects={username,password,phone,sex,mail,id};
        int i = userService.UpdateUser(objects);
        if(i==1){

            response.sendRedirect("UserFuzzyServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

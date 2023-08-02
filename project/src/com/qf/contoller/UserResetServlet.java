package com.qf.contoller;

import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserResetServlet", value = "/UserResetServlet")
public class UserResetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String id = request.getParameter("id");
        System.out.println(id);
        Object[] objects = {id};
        int i = userService.ResetPassword(objects);
        if (i == 1) {
            response.sendRedirect("UserFuzzyServlet");
        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

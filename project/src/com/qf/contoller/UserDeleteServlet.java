package com.qf.contoller;

import com.qf.dao.UserDao;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserDeleteServlet", value = "/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String id = request.getParameter("id");
        System.out.println(id);
        Object[] objects = {id};
        //连接数据库 删除数据
        Integer integer = userService.DeleteUserById(objects);
        if (integer == 1) {
            response.sendRedirect("UserFuzzyServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

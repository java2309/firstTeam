package com.qf.contoller;

import com.qf.entity.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserUpdateShowServlet", value = "/UserUpdateShowServlet")
public class UserUpdateShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
       Object[] objects = {id};
        List<User> users = userService.ShowUser(objects);
        User user = users.get(0);
        request.setAttribute("user",user);
        request.getRequestDispatcher("after/update.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

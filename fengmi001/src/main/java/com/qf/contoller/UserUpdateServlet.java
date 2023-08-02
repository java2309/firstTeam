package com.qf.contoller;

import com.qf.entity.User;
import com.qf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserUpdateServlet", value = "/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserServiceImpl userService = new UserServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        String pageNo = request.getParameter("pageNo");
        User user = new User(id,username, password, phone, sex, mail);
        userService.updateUser(user);
        request.setAttribute("pageNo",pageNo);

        request.getRequestDispatcher("UserFuzzyServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

package com.qf.contoller;

import com.qf.entity.User;
import com.qf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserShowServlet", value = "/UserShowServlet")
public class UserShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserServiceImpl userService = new UserServiceImpl();
        String id = request.getParameter("id");
        String pageNo = request.getParameter("pageNo");

        User user = userService.selectUserById(Integer.parseInt(id));
        request.setAttribute("username",user.getUsername());
        request.setAttribute("password",user.getPassword());
        request.setAttribute("phone",user.getPhone());
        request.setAttribute("sex",user.getSex());
        request.setAttribute("mail",user.getMail());
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("id",id);
        request.getRequestDispatcher("/after/admin_updateuser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

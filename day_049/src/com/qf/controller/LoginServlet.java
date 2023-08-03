package com.qf.controller;

import com.qf.service.TeacherService;
import com.qf.service.impl.TeacherServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    //可获取ajax传来的数据，也可传去数据
    TeacherService teacherService = new TeacherServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//处理post请求时候乱码问题
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println(user + ":"+ password);
        //从前端获取的数据比对数据库
        int login = teacherService.login(user, password);
        PrintWriter writer = response.getWriter();
        switch (login) {
            case 1://登陆成功
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(60*60*24);
                session.setAttribute("user", user);
                //给ajax响应的数据
                writer.write("{\"code\":1}");
                break;
            case 2://密码错误
                writer.write("{\"code\":2}");
                break;
            case 3://用户名不存在的情况
                writer.write("{\"code\":3}");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request, response);
    }
}

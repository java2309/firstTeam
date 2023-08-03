package com.sq.controller;

import com.sq.service.Impl.LoginServiceImpl;
import com.sq.service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService = new LoginServiceImpl();
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        System.out.println(name+":"+pwd);
        //从前端获取到数据,连接数据库做对比
        int login = loginService.login(name, pwd);
        PrintWriter writer = response.getWriter();
        switch (login){
            case 0:
                //登陆成功
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(60*60*24);
                session.setAttribute("name",name);
                //返回前端
                writer = response.getWriter();
                writer.write("{\"code\":0}");
                break;
            case 1:
                //密码不对
                writer = response.getWriter();
                writer.write("{\"code\":1}");
                break;
            case 2:
                //没有用户
                writer = response.getWriter();
                writer.write("{\"code\":2}");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

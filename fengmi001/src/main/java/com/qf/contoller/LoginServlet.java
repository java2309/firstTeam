package com.qf.contoller;

import com.qf.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        AdminServiceImpl adminService = new AdminServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean login = adminService.login(username, password);
        if (login){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*60*24);
            session.setAttribute("user",username);
            response.sendRedirect("UserFuzzyServlet");
        }else {
            response.getWriter().println("<script>alert('账号密码错误，请重试');window.location.href='after/login.jsp'</script>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

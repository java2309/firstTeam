package com.qf.contoller;

import com.qf.service.AdminService;
import com.qf.service.impl.AdminServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        //获取前端表单发送的数据
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取到以后和数据库中的数据作对比
        boolean login = adminService.login(username, password);
        if (login) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*60*24);
            session.setAttribute("user",username);
            //登陆后跳转到主页面 一个servlet
            response.sendRedirect("UserFuzzyServlet?pageNo=1");

        }else {
            response.getWriter().print("<script>alert('用户名或密码错误');window.location.href='/project/after/login.jsp'</script>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}

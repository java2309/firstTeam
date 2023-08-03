package com.qf.controller; /**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */

import com.qf.service.TeacherService;
import com.qf.service.impl.TeacherServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    TeacherService teacherService = new TeacherServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ajax请求LoginServlet这个资源，并带着input输入框中的数据 给LoginServlet
        //LoginServlet可以接受到前端发送的数据
        request.setCharacterEncoding("utf-8");//处理post请求时候乱码问题
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println(user + ":"+ password);
        //获取到前端input输入框中的数据  连接数据库做比对判断是否相等
        int login = teacherService.login(user, password);
        PrintWriter writer = response.getWriter();
        switch (login) {

            case 1:
                //登陆成功
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(60*60*24);
                session.setAttribute("user", user);
                //给ajax响应的数据

                writer.write("{\"code\":1}");
                break;
            case 2:
                //用户名不存在的情况

                writer.write("{\"code\":2}");
                break;
            case 3:
                //密码错误
                writer.write("{\"code\":3}");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

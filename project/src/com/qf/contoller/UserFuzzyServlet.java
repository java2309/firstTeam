package com.qf.contoller;

import com.qf.entity.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

//目前这个servlet展示table表格中的数据
@WebServlet(name = "UserFuzzyServlet", value = "/UserFuzzyServlet")
public class UserFuzzyServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pageNo = request.getParameter("pageNo");
        int page = 1; // 默认页数，如果转换失败，默认为第一页
        try {
            page = Integer.parseInt(pageNo);
            System.out.println("当前页数" + page);
        } catch (NumberFormatException e) {
            // 处理转换异常，比如打印错误日志或设置一个默认值
            e.printStackTrace();
        }

        System.out.println("当前页数"+page);
        List<User> select = userService.select(page);
        int latest = userService.SelectLatest();
        request.setAttribute("users",select);
        request.setAttribute("pageNo",page);
        request.setAttribute("pageCount",latest);
        request.getRequestDispatcher("/after/user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

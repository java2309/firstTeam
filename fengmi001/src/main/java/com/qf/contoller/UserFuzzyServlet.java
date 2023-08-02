package com.qf.contoller;

import com.qf.entity.User;
import com.qf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserFuzzyServlet", value = "/UserFuzzyServlet")
public class UserFuzzyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserServiceImpl userService = new UserServiceImpl();
//        接收迷糊查询条件
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        User user = new User();
        if (username==null){
            username="";
        }
        if (sex==null){
            sex="";
        }
        if (!username.equals("")){
            user.setUsername(username);
        }
        if (!sex.equals("")){
            user.setSex(sex);
        }
//        分页
        int pageNo;
        int pageCount;
        int pageSize=5;
        String pageNo1 = request.getParameter("pageNo");
        if (pageNo1==null){
            pageNo=1;
        }else {
            pageNo= Integer.parseInt(pageNo1);
        }
        int count = userService.selectUserCount(user);
        pageCount= count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        if (count==0){
            pageCount=1;
        }
        if (pageNo>pageCount){
            pageNo--;
        }
//        查询

        List<User> list = null;
        if (userService.fuzzyQueryAllUser(user,pageNo,pageSize)!=null){
            list = userService.fuzzyQueryAllUser(user,pageNo,pageSize);
        }


//        带数据转发

        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.setAttribute("username",username);
        request.setAttribute("sex",sex);
        request.getRequestDispatcher("/after/user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

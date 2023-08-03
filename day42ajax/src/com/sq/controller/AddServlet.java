package com.sq.controller;

import com.alibaba.fastjson.JSON;
import com.sq.entity.Z;
import com.sq.service.Impl.StudentServiceImpl;
import com.sq.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String info = request.getParameter("info");
        Object[] obj = {name,age,info};

        Boolean add = studentService.add(obj);
        PrintWriter writer = response.getWriter();
        if (add){
            Z z = new Z<>();
            z.setCode(0);
            z.setMsg("删除成功");
            String s = JSON.toJSONString(z);
            writer.write(s);
        }else {
            Z z = new Z<>();
            z.setCode(1);
            z.setMsg("删除失败");
            String s = JSON.toJSONString(z);
            writer.write(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

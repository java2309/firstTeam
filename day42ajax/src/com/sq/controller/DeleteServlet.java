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

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        //接收前端资源
        String id = request.getParameter("id");
        response.setContentType("text/html;charset=utf-8");
        Integer integer = Integer.valueOf(id);
        Boolean aBoolean = studentService.delStu(integer);
        PrintWriter writer = response.getWriter();
        if (aBoolean){
            Z z = new Z<>();
            z.setCode(1);
            z.setMsg("删除成功");
            String s = JSON.toJSONString(z);
            writer.write(s);
        }else {
            Z z = new Z<>();
            z.setCode(0);
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

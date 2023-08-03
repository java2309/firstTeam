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

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        String stu_name = request.getParameter("name");
        String age = request.getParameter("age");
        String info = request.getParameter("info");
        Object[] obj = {id,stu_name,age,info};
        Boolean update = studentService.update(obj);
        PrintWriter writer = response.getWriter();
        if (update){
            Z z = new Z();
            z.setCode(0);
            z.setMsg("修改成功");
            String s = JSON.toJSONString(z);
            writer.write(s);
        }else {
            Z z = new Z();
            z.setCode(1);
            z.setMsg("修改失败");
            String s = JSON.toJSONString(z);
            writer.write(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

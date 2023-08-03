package com.qf.controller;

import com.alibaba.fastjson.JSON;
import com.qf.entity.R;
import com.qf.service.StudentService;
import com.qf.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String stu_name = request.getParameter("name");
        String age = request.getParameter("age");
        String info = request.getParameter("info");
        System.out.println(id + ":"+stu_name + ":"+ age + ":" + info);
        //sql语句
        //update student set stu_name=?, age=?, info=? where id = ?
        Object[] objs = {stu_name, age, info, id};
        int update = studentService.update(objs);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if (update == 1) {
            //删除成功
            R r = new R();
            r.setCode(1);
            r.setMsg("修改成功");
            String s = JSON.toJSONString(r);
            writer.write(s);
        } else {
            //删除失败
            R r = new R();
            r.setCode(0);
            r.setMsg("修改失败");
            String s = JSON.toJSONString(r);
            writer.write(s);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request, response);
    }
}

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

@WebServlet(value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收前端发送的数据
        String id = request.getParameter("id");
        Integer id1 = Integer.valueOf(id);
        //sql  delete from student where id = ?
        int i = studentService.delStu(id1);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if (i == 1) {
            //删除成功
            R r = new R();
            r.setCode(1);
            r.setMsg("删除成功");
            String s = JSON.toJSONString(r);
            writer.write(s);
        } else {
            //删除失败
            R r = new R();
            r.setCode(0);
            r.setMsg("删除失败");
            String s = JSON.toJSONString(r);
            writer.write(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}

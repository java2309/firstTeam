package com.qf.controller;

import com.alibaba.fastjson.JSON;
import com.qf.entity.R;
import com.qf.entity.Student;
import com.qf.service.StudentService;
import com.qf.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/IndexServlet")
    public class IndexServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = (String) request.getSession().getAttribute("user");
        Integer page = Integer.valueOf(request.getParameter("page"));//第几页
        Integer limit = Integer.valueOf(request.getParameter("limit"));//要几个
        int count = studentService.selectSizeByName(name);//总条数
        List<Student> allStudent = studentService.getAllStudent(name,(page - 1) * limit, limit );
        PrintWriter writer = response.getWriter();

        //返回前端
        R<Student> studentR = new R<>();
        studentR.setCode(0);
        studentR.setMsg("学生的信息");
        studentR.setCount(count);
        studentR.setData(allStudent);
        //只需要这个对象转为json字符串  fastJson
        String s = JSON.toJSONString(studentR);
        writer.write(s);//返回给前端
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}

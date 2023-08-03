package com.sq.controller;

import com.alibaba.fastjson.JSON;
import com.sq.entity.Studen;
import com.sq.entity.Z;
import com.sq.service.Impl.StudentServiceImpl;
import com.sq.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = (String)request.getSession().getAttribute("name");
        Integer page = Integer.valueOf(request.getParameter("page"));
        Integer limit = Integer.valueOf(request.getParameter("limit"));
        //总条数
        int count = studentService.selectSize(name);

        List<Studen> allStrudent = studentService.getAllStrudent(name,page,limit);
        PrintWriter writer = response.getWriter();
        //writer.write("{\"code\":0,\"msg\":\"学生的信息\",\"data\":"+allStrudent+"}");

        Z<Studen> studenZ = new Z<>();
        studenZ.setCode(0);
        studenZ.setMsg("学生的信息");
        studenZ.setCount(count);
        studenZ.setData(allStrudent);
        //对象转为json字符串
        String s = JSON.toJSONString(studenZ);
        writer.write(s);//返回给前端
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

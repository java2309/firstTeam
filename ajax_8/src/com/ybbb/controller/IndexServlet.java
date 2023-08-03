package com.ybbb.controller;


import com.alibaba.fastjson2.JSON;
import com.ybbb.dao.TeacherDao;
import com.ybbb.dao.TeacherDaoImpl;
import com.ybbb.pojo.R;
import com.ybbb.pojo.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Object name = session.getAttribute("user");
        String name1 = name.toString();
        String page = request.getParameter("page");
        Integer i = Integer.valueOf(page);
        String limit = request.getParameter("limit");
        Integer j=Integer.valueOf(limit);
        int page1 = (i - 1) * j;
        Object[] objects = {name,page1,j};

        int count = teacherDao.selectStudentCount(name1);
        List<Student> students = teacherDao.selectStudent(objects);
        PrintWriter writer = response.getWriter();
        R<Student> studentR = new R<>();
        studentR.setCode(0);
        studentR.setMsg("学生的信息");
        studentR.setCount(count);
        studentR.setData(students);
        //只需要这个对象转为json字符串  fastJson
        String s = JSON.toJSONString(studentR);
        writer.write(s);//返回给前端
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);   }
}
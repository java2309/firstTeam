package com.ybbb.controller;

import com.ybbb.dao.TeacherDao;
import com.ybbb.dao.TeacherDaoImpl;
import com.ybbb.pojo.Teacher;
import com.ybbb.service.TeacherService;
import com.ybbb.service.TeacherServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    TeacherDao  studentDao = new TeacherDaoImpl();
    TeacherService teacherService = new TeacherServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("user");
        String password = request.getParameter("password");
        List<Teacher> teachers = studentDao.selectUser(name);
        Integer id = teachers.get(0).getId();
        int i = teacherService.selectUser(name, password);
        PrintWriter writer = response.getWriter();
        switch (i) {
            case 1:
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(60*60*24);
                session.setAttribute("user",name);
                session.setAttribute("id",id);
                writer.write("{\"code\":0}");
                break;
            case 2:
                writer.write("{\"code\":2}");
                break;
            case 3:
                writer.write("{\"code\":3}");
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
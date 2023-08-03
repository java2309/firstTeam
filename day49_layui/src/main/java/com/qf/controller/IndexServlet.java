package com.qf.controller; /**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */

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

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //只需要查询student表数据即可
        response.setContentType("text/html;charset=utf-8");
        String name = (String)request.getSession().getAttribute("user");
        List<Student> allStudent = studentService.getAllStudent(name);
        PrintWriter writer = response.getWriter();

        R<Student> studentR = new R<>();
        studentR.setCode(1);
        studentR.setMsg("学生的信息");
        studentR.setData(allStudent);
        //只需要这个对象转为json字符串  fastJson
        String s = JSON.toJSONString(studentR);
        writer.write(s);//返回给前端

        //writer.write("{\"code\":1, \"msg\":\"学生的信息\", \"data\":"+allStudent+"}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

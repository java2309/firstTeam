package com.qf.contoller;

import com.qf.service.GoodsTypeService;
import com.qf.service.impl.GoodsTypeServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GoodsTypeUpdateServlet", value = "/GoodsTypeUpdateServlet")
public class GoodsTypeUpdateServlet extends HttpServlet {
    GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String typename = req.getParameter("typename");
        if (id.isEmpty()||id == null){
            Object[] objects = {typename};
            goodsTypeService.GoodsTypeAdd(objects);
            resp.getWriter().print("<script>alert('添加成功');window.location.href='/project/GoodsTypeSelectServlet';</script>");
        }else {
            Object[] objects = {typename,id};
            goodsTypeService.GoodsTypeUpdate(objects);
            resp.getWriter().print("<script>alert('修改成功');window.location.href='/project/GoodsTypeSelectServlet';</script>");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

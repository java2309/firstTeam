package com.qf.contoller;

import com.qf.service.GoodsTypeService;
import com.qf.service.impl.GoodsTypeServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GoodsTypeDeleteServlet", value = "/GoodsTypeDeleteServlet")
public class GoodsTypeDeleteServlet extends HttpServlet {
    GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        Object[] objects = {id};
        int i = goodsTypeService.GoodsTypeDelete(objects);
        if (i == 1) {
            response.sendRedirect("GoodsTypeSelectServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

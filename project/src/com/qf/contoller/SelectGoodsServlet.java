package com.qf.contoller;

import com.qf.entity.Goods;
import com.qf.service.GoodsService;
import com.qf.service.impl.GoodsServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectGoodsServlet", value = "/SelectGoodsServlet")
public class SelectGoodsServlet extends HttpServlet {
    GoodsService goodsService = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

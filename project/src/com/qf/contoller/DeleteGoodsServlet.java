package com.qf.contoller;

import com.qf.service.GoodsService;
import com.qf.service.impl.GoodsServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteGoodsServlet", value = "/DeleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String goodsid = request.getParameter("goodsid");
        String arr[] = goodsid.split(",,");
        System.out.println(goodsid);
        for (String s: arr) {
            Object[] objects = {s};
            System.out.println(s);
            goodsService.GoodsDelete(objects);
        }
        request.getRequestDispatcher("FuzzySelectGoods").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

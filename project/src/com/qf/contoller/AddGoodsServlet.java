package com.qf.contoller;

import com.qf.service.GoodsService;
import com.qf.service.impl.GoodsServiceImpl;
import com.qf.util.DateUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddGoodsServlet", value = "/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsServiceImpl();
        DateUtil dateUtil = new DateUtil();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String goodsName = request.getParameter("goodsName");
        String price = request.getParameter("price");
        String deployDate = dateUtil.currentTime();
        String imgPath = request.getParameter("imgPath");
        String typeId = request.getParameter("typeId");
        String comment = request.getParameter("comment");

        if (id == null || "".equals(id)) {
            Object[] object = {goodsName, price,deployDate,imgPath, comment,typeId };
            goodsService.GoodsAdd(object);
            response.sendRedirect(request.getContextPath() + "/FuzzySelectGoods");
        } else {
            Object[] object = { goodsName, price, imgPath,comment, typeId,id};
            goodsService.GoodsUpdate(object);
            response.sendRedirect(request.getContextPath() + "/FuzzySelectGoods");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

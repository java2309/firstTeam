package com.qf.contoller;


import com.qf.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddGoodsServlet", value = "/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyy-MM-dd");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        String id = request.getParameter("id");
        String goodsName = request.getParameter("goodsName");
        String price = request.getParameter("price");
        String score = request.getParameter("score");
        String typeId = request.getParameter("typeId");
        String imgPath = request.getParameter("imgPath");
        String comment = request.getParameter("comment");
        String pageNo = request.getParameter("pageNo");
        if (id.equals("")){
            if (score.equals("")){
                score="0";
            }
            Date date = new Date();
            String deployDate= simpleDateFormat.format(date);
            Object[] objects={goodsName,price,score,deployDate,typeId,imgPath,comment};
            goodsService.addGoods(objects);
        }else {
            Object[] objects={goodsName,price,score,typeId,imgPath,comment,Integer.parseInt(id)};
        }
        request.setAttribute("pageNo",pageNo);

        response.sendRedirect("FuzzySelectGoods");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

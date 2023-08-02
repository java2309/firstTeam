package com.qf.contoller;

import com.qf.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteGoodsServlet", value = "/DeleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        String goodsName = request.getParameter("goodsName");
        String deployDate = request.getParameter("deployDate");
        String id = request.getParameter("typeId");
        String pageNo = request.getParameter("pageNo");
        String goodsId = request.getParameter("goodsId");
        String[] goodsIds = goodsId.split(",,");
        for (String s : goodsIds) {
            if (!s.equals("")){
                goodsService.delGoods(Integer.parseInt(s));
            }

        }
        request.setAttribute("goodsName",goodsName);
        request.setAttribute("deployDate",deployDate);
        request.setAttribute("typeId",id);
        request.setAttribute("pageNo",pageNo);
        request.getRequestDispatcher("FuzzySelectGoods").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

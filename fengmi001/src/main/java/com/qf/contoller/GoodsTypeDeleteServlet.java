package com.qf.contoller;

import com.qf.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GoodsTypeDeleteServlet", value = "/GoodsTypeDeleteServlet")
public class GoodsTypeDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
        String id = request.getParameter("id");
        goodsTypeService.delGoodsTypeById(Integer.parseInt(id));
        String pageNo = request.getParameter("pageNo");
        request.setAttribute("pageNo",pageNo);
        request.getRequestDispatcher("GoodsTypeSelectServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

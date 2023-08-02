package com.qf.contoller;

import com.qf.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GoodsTypeUpdateServlet", value = "/GoodsTypeUpdateServlet")
public class GoodsTypeUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
        String typename = request.getParameter("typename");
        int pageNo;
        String pageNo1 = request.getParameter("pageNo");
        if (pageNo1==null||pageNo1.equals("")){
            pageNo=1;
        }else {
            pageNo= Integer.parseInt(pageNo1);
        }
        String id = request.getParameter("id");
        if (id!=null&& !id.equals("")){
            goodsTypeService.updateGoodsType(typename, Integer.parseInt(id));
        }else {
            goodsTypeService.addGoodsType(typename);
        }
        request.setAttribute("pageNo",pageNo);

        request.getRequestDispatcher("GoodsTypeSelectServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

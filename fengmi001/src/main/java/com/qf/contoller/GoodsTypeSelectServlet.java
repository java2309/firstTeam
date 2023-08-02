package com.qf.contoller;

import com.qf.entity.GoodsType;
import com.qf.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsTypeSelectServlet", value = "/GoodsTypeSelectServlet")
public class GoodsTypeSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
//        分页
        int pageNo;
        int pageCount;
        int pageSize=4;
        String pageNo1 = request.getParameter("pageNo");

        if (pageNo1==null||pageNo1.equals("")){
            pageNo=1;
        }else {
            pageNo= Integer.parseInt(pageNo1);
        }
        int count = goodsTypeService.selectGoodsTypeCount();
        if (count%pageSize==0){
            pageCount=count/pageSize;
        }else {
            pageCount=count/pageSize+1;
        }
        if (count==0){
            pageCount=1;
        }

        //        查询

        List<GoodsType> list = null;
        if (goodsTypeService.queryAllGoodsType(pageNo,pageSize)!=null){
            list = goodsTypeService.queryAllGoodsType(pageNo,pageSize);
        }


//        带数据转发

        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/after/goods_type_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

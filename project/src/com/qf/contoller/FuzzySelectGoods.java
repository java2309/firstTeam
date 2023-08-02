package com.qf.contoller;

import com.qf.entity.Goods;
import com.qf.entity.GoodsType;
import com.qf.service.GoodsService;
import com.qf.service.impl.GoodsServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FuzzySelectGoods", value = "/FuzzySelectGoods")
public class FuzzySelectGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsServiceImpl();

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pageNo = request.getParameter("pageNo");
        int page = 1; // 默认页数，如果转换失败，默认为第一页
        if (pageNo != null && !pageNo.isEmpty()) {
            try {
                page = Integer.parseInt(pageNo);
                System.out.println("当前页数" + page);
            } catch (NumberFormatException e) {
                // 处理转换异常，比如打印错误日志或设置一个默认值
                e.printStackTrace();
            }
        }


        System.out.println("当前页数"+page);
            List<Goods> goods = goodsService.SelectGoods(page);

        int latest = goodsService.SelectLatest();
        //request.setAttribute("username", "your_username_value");
        request.setAttribute("list",goods);
        request.setAttribute("pageNo",page);
        request.setAttribute("pageCount",latest);
            request.getRequestDispatcher("/after/goods_list.jsp").forward(request,response);
       // System.out.println(goods);
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }
}

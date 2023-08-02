package com.qf.contoller;

import com.qf.dao.impl.GoodsTypeDaoImpl;
import com.qf.entity.GoodsType;
import com.qf.service.GoodsTypeService;
import com.qf.service.impl.GoodsTypeServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsTypeSelectServlet", value = "/GoodsTypeSelectServlet")
public class GoodsTypeSelectServlet extends HttpServlet {
     GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        List<GoodsType> select = goodsTypeService.SelectGoodsType(page);
        int latest = goodsTypeService.SelectLatest();
        //request.setAttribute("username", "your_username_value");
        request.setAttribute("goodsType",select);
        request.setAttribute("pageNo",page);
        request.setAttribute("pageCount",latest);
        request.getRequestDispatcher("/after/goods_type_list.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

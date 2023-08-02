package com.qf.contoller;

import com.qf.dao.OrderDao;
import com.qf.dao.impl.OrderDaoImpl;
import com.qf.entity.Order;
import com.qf.service.GoodsService;
import com.qf.service.impl.GoodsServiceImpl;
import com.qf.service.impl.OrderServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderFuzzySelectServlet", value = "/OrderFuzzySelectServlet")
public class OrderFuzzySelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<Order> orders = orderService.SelectOrder();
        request.setAttribute("orders",orders);
        System.out.println(orders);
        request.getRequestDispatcher("/after/order_processing_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

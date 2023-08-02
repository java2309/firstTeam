package com.qf.contoller;

import com.qf.dao.OrderDao;
import com.qf.dao.impl.OrderDaoImpl;
import com.qf.service.impl.OrderServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteOrderServlet", value = "/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        String id = request.getParameter("ordersid");
        System.out.println();
        Object[] objects = {id};
        int i = orderService.DeleteOrder(objects);
        if (i == 1) {
            response.sendRedirect("OrderFuzzySelectServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

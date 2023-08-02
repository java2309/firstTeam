package com.qf.contoller;

import com.qf.service.OrderService;
import com.qf.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteOrderServlet", value = "/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        OrderService orderService = new OrderServiceImpl();
        String id = request.getParameter("ordersid");
        String pageNo = request.getParameter("pageNo");
        String username = request.getParameter("username");
        String statusId = request.getParameter("statusId");
        orderService.ddelOrdersById(Integer.parseInt(id));
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("username",username);
        request.setAttribute("statusId",statusId);
        request.setAttribute("pageNo",pageNo);
        request.getRequestDispatcher("OrderFuzzySelectServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

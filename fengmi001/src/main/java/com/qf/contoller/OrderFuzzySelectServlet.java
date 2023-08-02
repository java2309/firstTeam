package com.qf.contoller;

import com.qf.entity.Order;
import com.qf.service.OrderService;
import com.qf.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderFuzzySelectServlet", value = "/OrderFuzzySelectServlet")
public class OrderFuzzySelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        OrderService orderService = new OrderServiceImpl();
        //        接收迷糊查询条件
        String username = request.getParameter("username");
        String statusId = request.getParameter("statusId");


        if (username==null){
            username="";
        }
        if (statusId==null){
            statusId="";
        }
//        分页
        int pageNo;
        int pageCount;
        int pageSize=5;
        String pageNo1 = request.getParameter("pageNo");
        if (pageNo1==null){
            pageNo=1;
        }else {
            pageNo= Integer.parseInt(pageNo1);
        }
        int count = orderService.selectOrderCount(username,statusId);
        if (count % pageSize != 0) {
            pageCount=count/pageSize+1;
        } else {
            pageCount=count/pageSize;
        }
        if (count==0){
            pageCount=1;
        }
        if (pageNo>pageCount){
            pageNo--;
        }
//        查询

        List<Order> list = null;
        if (orderService.fuzzyQueryAllOrder(username,statusId,pageNo,pageSize)!=null){
            list = orderService.fuzzyQueryAllOrder(username,statusId,pageNo,pageSize);
        }
//        带数据转发
        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.setAttribute("username",username);
        request.setAttribute("statusId",statusId);
        request.getRequestDispatcher("/after/order_processing_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

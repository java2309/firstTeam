package com.qf.contoller;

import com.qf.entity.Goods;
import com.qf.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "FuzzySelectGoods", value = "/FuzzySelectGoods")
public class FuzzySelectGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyy-MM-dd");

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
//        接收模糊查询条件
        String goodsName = request.getParameter("goodsName");
        String deployDate = request.getParameter("deployDate");
        String id = request.getParameter("typeId");
        Goods goods = new Goods();
        if (goodsName==null){
            goodsName="";
        }
        if (deployDate==null){
            deployDate="";
        }
        if (id==null){
            id="";
        }
        if (!goodsName.equals("")){
            goods.setGoodsName(goodsName);
        }
        if (!deployDate.equals("")){
            try {
                goods.setDeployDate(simpleDateFormat.parse(deployDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (!id.equals("")){
            goods.setTypeId(Integer.valueOf(id));
        }
//       分页
        int pageNo;
        int pageCount;
        int pageSize=5;
        String pageNo1 = request.getParameter("pageNo");
        if (pageNo1==null){
            pageNo=1;
        }else {
            pageNo= Integer.parseInt(pageNo1);
        }
        int count = goodsService.selectGoodsCount(goods);
        if (count%pageSize==0){
            pageCount=count/pageSize;
        }else {
            pageCount=count/pageSize+1;
        }
        if (count==0){
            pageCount=1;
        }

        if (pageNo>pageCount){
            pageNo--;
        }

//        查询

        List<Goods> list = null;
        if (goodsService.fuzzyQueryAllGoods(goods,pageNo,pageSize)!=null){
            list = goodsService.fuzzyQueryAllGoods(goods,pageNo,pageSize);
        }


//        带数据转发
        request.setAttribute("goodsName",goodsName);
        request.setAttribute("deployDate",deployDate);
        request.setAttribute("typeId",id);
        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/after/goods_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package com.qf.service.impl;

import com.qf.dao.GoodsTypeDao;
import com.qf.dao.OrderDao;
import com.qf.dao.impl.GoodsTypeDaoImpl;
import com.qf.dao.impl.OrderDaoImpl;
import com.qf.entity.Order;
import com.qf.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderTypeDao =new OrderDaoImpl();
    @Override
    public List<Order> SelectOrder() {
        List<Order> orders = orderTypeDao.SelectOrder();
        return orders;
    }

    @Override
    public int DeleteOrder(Object[] objects) {
        int i = orderTypeDao.DeleteOrder(objects);
        return i;
    }
}

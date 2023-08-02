package com.qf.dao;

import com.qf.entity.Goods;
import com.qf.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> SelectOrder();
    int DeleteOrder(Object[] objects);
}

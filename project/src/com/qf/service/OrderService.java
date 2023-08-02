package com.qf.service;

import com.qf.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> SelectOrder();
    int DeleteOrder(Object[] objects);
}

package com.qf.service;

import com.qf.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> fuzzyQueryAllOrder(String username,String statusId, int pageNo, int pageSize);
    int selectOrderCount(String username,String statusId);
    Boolean ddelOrdersById(int id);
}

package com.qf.dao;

import com.qf.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> queryAllOrder(int pageNo, int pageSize);
    List<Order> queryAllOrderByUid(int uid, int pageNo, int pageSize);
    List<Order> queryAllOrderByStatusId(int statusId,int pageNo, int pageSize);
    List<Order> queryAllOrderByUidAndStatusId(int uid, int statusId, int pageNo, int pageSize);
    int selectOrderCount();
    int selectOrderCountByUid(int uid);
    int selectOrderCountByStatusId(int statusId);
    int selectOrderCountByUidAndStatusId(int uid,int statusId);
    int delOrderById(int id);
}

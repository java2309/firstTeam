package com.qf.dao.impl;

import com.qf.dao.OrderDao;
import com.qf.entity.Order;
import com.qf.util.BaseDao;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public List<Order> SelectOrder() {
        String sql = "SELECT tr.id,tr.orderCode,tr.totalPrice,tr.createDate,ts.order_status,tu.username FROM t_order tr JOIN t_status ts on tr.status=ts.id JOIN t_user tu on tr.uid=tu.id ";
        List<Order> orders = super.query(sql, null, Order.class);
        return orders;
    }

    @Override
    public int DeleteOrder(Object[] objects) {
        String sql = "delete from t_order where id = ?";
        int update = super.update(sql, objects);
        return update;
    }
}

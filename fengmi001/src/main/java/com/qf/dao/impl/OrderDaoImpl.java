package com.qf.dao.impl;

import com.qf.dao.OrderDao;
import com.qf.entity.Order;
import com.qf.utils.BaseDao;

import java.util.List;
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public List<Order> queryAllOrder(int pageNo, int pageSize) {
        String sql="select * from t_order limit ?,?";
        Object[] objects={(pageNo-1)*pageSize,pageSize};
        return super.query(sql,objects, Order.class);
    }

    @Override
    public List<Order> queryAllOrderByUid(int uid, int pageNo, int pageSize) {
        String sql="select * from t_order where uid =? limit ?,?";
        Object[] objects={uid,(pageNo-1)*pageSize,pageSize};
        return super.query(sql,objects, Order.class);
    }

    @Override
    public List<Order> queryAllOrderByStatusId(int statusId, int pageNo, int pageSize) {
        String sql="select * from t_order where statusId = ? limit ?,?";
        Object[] objects={statusId,(pageNo-1)*pageSize,pageSize};
        return super.query(sql,objects, Order.class);
    }

    @Override
    public List<Order> queryAllOrderByUidAndStatusId(int uid, int statusId, int pageNo, int pageSize) {
        String sql="select * from t_order where uid =? and statusId = ? limit ?,?";
        Object[] objects={uid,statusId,(pageNo-1)*pageSize,pageSize};
        return super.query(sql,objects, Order.class);
    }

    @Override
    public int selectOrderCount() {
        String sql="select count(*) from t_order";
        return super.selectCount(sql);
    }

    @Override
    public int selectOrderCountByUid(int uid) {
        String sql="select count(*) from t_order where uid ="+uid;

        return super.selectCount(sql);
    }

    @Override
    public int selectOrderCountByStatusId(int statusId) {
        String sql="select count(*) from t_order where statusId = "+statusId ;

        return super.selectCount(sql);
    }

    @Override
    public int selectOrderCountByUidAndStatusId(int uid, int statusId) {
        String sql="select count(*) from t_order where uid ="+uid+" and statusId = "+statusId;
        return super.selectCount(sql);
    }

    @Override
    public int delOrderById(int id) {
        String sql="delete from t_order where id=?";
        Object[] objects={id};
        return super.update(sql,objects);
    }
}

package com.qf.service.impl;

import com.qf.dao.OrderDao;
import com.qf.dao.UserDao;
import com.qf.dao.impl.OrderDaoImpl;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.entity.Order;
import com.qf.entity.User;
import com.qf.service.OrderService;
import com.qf.utils.BaseDao;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl extends BaseDao implements OrderService {
    OrderDao orderDao=new OrderDaoImpl();
    UserDao userDao=new UserDaoImpl();
    @Override
    public List<Order> fuzzyQueryAllOrder(String username, String statusId, int pageNo, int pageSize) {
        if (username.equals("")&&statusId.equals("")){
            return orderDao.queryAllOrder(pageNo, pageSize);
        } else if (username.equals("")&!statusId.equals("")) {
            return orderDao.queryAllOrderByStatusId(Integer.parseInt(statusId),pageNo,pageSize);
        } else if (statusId.equals("")) {
            List<Order> list=new ArrayList<>();
            List<User> users = userDao.selectUsersByName(username);
            for (User user : users) {
                list.addAll(orderDao.queryAllOrderByUid(user.getId(),pageNo,pageSize));
            }
            return list;
        } else {
            List<Order> list=new ArrayList<>();
            List<User> users = userDao.selectUsersByName(username);
            for (User user : users) {
                list.addAll(orderDao.queryAllOrderByUidAndStatusId(user.getId(), Integer.parseInt(statusId),pageNo,pageSize));
            }
            return list;
        }

    }

    @Override
    public int selectOrderCount(String username, String statusId) {
        if (username.equals("")&&statusId.equals("")){
            return orderDao.selectOrderCount();
        } else if (username.equals("")&!statusId.equals("")) {
            return orderDao.selectOrderCountByStatusId(Integer.parseInt(statusId));
        } else if (statusId.equals("")) {
            int count=0;
            List<User> users = userDao.selectUsersByName(username);
            for (User user : users) {
                count+=orderDao.selectOrderCountByUid(user.getId());
            }
            return count;
        } else {
            int count=0;
            List<User> users = userDao.selectUsersByName(username);

            for (User user : users) {
                count+=orderDao.selectOrderCountByUidAndStatusId(user.getId(), Integer.parseInt(statusId));
            }
            return count;
        }
    }

    @Override
    public Boolean ddelOrdersById(int id) {
        return orderDao.delOrderById(id)==1;
    }
}

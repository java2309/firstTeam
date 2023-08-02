package com.qf.entity;

import com.qf.dao.StatusDao;
import com.qf.dao.UserDao;
import com.qf.dao.impl.StatusDaoImpl;
import com.qf.dao.impl.UserDaoImpl;

import java.util.Date;

public class Order {
    StatusDao statusDao=new StatusDaoImpl();
    UserDao userDao=new UserDaoImpl();
    private Integer id;
    private String orderCode;
    private Double totalPrice;
    private Date createDate;
    private Integer uid;
    private Integer statusId;
    private User user;
    private Status status;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getuid() {
        return uid;
    }

    public void setuid(Integer uid) {
        if (userDao.selectUserById(uid)!=null){
            this.user=userDao.selectUserById(uid);
        }
        this.uid = uid;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.status=statusDao.selectStatusById(statusId);
        this.statusId = statusId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "statusDao=" + statusDao +
                ", userDao=" + userDao +
                ", id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", totalPrice=" + totalPrice +
                ", createDate=" + createDate +
                ", uid=" + uid +
                ", statusId=" + statusId +
                ", user=" + user +
                ", status=" + status +
                '}';
    }
}

package com.qf.entity;

import java.util.Date;

public class Order  {
    private Integer id;
    private String orderCode;
    private double totalPrice;
    private String order_status;
    private Date createDate;
   // private Integer uid;
    //private Integer status;
    private String username;


    public Order(Integer id, String orderCode, double totalPrice, String order_status, Date createDate, String username) {
        this.id = id;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.order_status = order_status;
        this.createDate = createDate;
        this.username = username;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", totalPrice=" + totalPrice +
                ", order_status='" + order_status + '\'' +
                ", createDate=" + createDate +
                ", username='" + username + '\'' +
                '}';
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


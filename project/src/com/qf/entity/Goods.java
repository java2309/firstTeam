package com.qf.entity;


import java.util.Date;

public class Goods {
    private int id;
    private String goodsName;
    private double price;
    private Date deployDate;
    private String imgPath;
    private String comment;
    private String typename;
    private Integer typeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(Date deployDate) {
        this.deployDate = deployDate;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Goods() {
    }

    public Goods(int id, String goodsName, double price, Date deployDate, String imgPath, String comment, String typename, Integer typeId) {
        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
        this.deployDate = deployDate;
        this.imgPath = imgPath;
        this.comment = comment;
        this.typename = typename;
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", deployDate=" + deployDate +
                ", imgPath='" + imgPath + '\'' +
                ", comment='" + comment + '\'' +
                ", typename='" + typename + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}
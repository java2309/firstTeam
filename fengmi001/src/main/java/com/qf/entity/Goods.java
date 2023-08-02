package com.qf.entity;

import com.qf.dao.GoodsTypeDao;
import com.qf.dao.impl.GoodsTypeDaoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Goods {

    GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImpl();
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyy-MM-dd");
    private Integer id;
    private String goodsName;
    private Double price;
    private Integer score;
    private Date deployDate;
    private String imgPath;
    private String comment;
    private Integer typeId;
    private GoodsType goodsType;

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public Goods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
        this.goodsType= goodsTypeDao.selectGoodsTypeById(typeId);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsTypeDao=" + goodsTypeDao +
                ", simpleDateFormat=" + simpleDateFormat +
                ", id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", score=" + score +
                ", deployDate=" + deployDate +
                ", imgPath='" + imgPath + '\'' +
                ", comment='" + comment + '\'' +
                ", typeId=" + typeId +
                ", goodsType=" + goodsType +
                '}';
    }

    public Goods(String goodsName, Double price, Integer score, Date deployDate, String imgPath, String comment, Integer typeId) {
        this.goodsName = goodsName;
        this.price = price;
        this.score = score;
        this.deployDate = deployDate;
        this.imgPath = imgPath;
        this.comment = comment;
        this.typeId = typeId;
    }
}

package com.qf.dao.impl;

import com.qf.dao.GoodsDao;
import com.qf.entity.Goods;
import com.qf.util.BaseDao;

import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    public List<Goods> SelectGoods(Integer page) {
        String sql = "SELECT t_goods.*,t_goodstype.typename FROM t_goods INNER JOIN t_goodstype ON t_goods.typeId = t_goodstype.id limit " + (page - 1) * 5 + "," + 5;
        return super.query(sql, null, Goods.class);
    }

    @Override
    public void GoodsDelete(Object[] objects) {
        String sql = "delete from t_goods where id = ?";
        super.update(sql, objects);

    }

    @Override
    public List<Goods> getGoodsById(Object[] objects) {
        String sql = "SELECT tg.id,tg.goodsName,tg.price,tg.score,tg.deployDate,tg.imgPath,tg.comment,tgt.typename,tg.typeId FROM t_goods tg LEFT JOIN t_goodstype tgt on tg.typeId=tgt.id where tg.id=?";
        List<Goods> query = super.query(sql, objects, Goods.class);
        return query;
    }

    @Override
    public int GoodsAdd(Object[] objects) {
        String sql = "INSERT into t_goods (goodsName,price,deployDate,imgPath,comment,typeId) VALUES(?,?,?,?,?,?)";
        return super.update(sql, objects);
    }

    @Override
    public int GoodsUpdate(Object[] objects) {
        String sql = "UPDATE t_goods set goodsName=?,price=?,imgPath=?,comment= ?,typeId = ? where id= ?";
        return super.update(sql, objects);
    }

    public int SelectAllSize() {
        String sql = "select count(*) from t_goods";//查询所有的总条数
        int i = super.querySize(sql);
        return i;


        // @Override
        //public int batchDelete(String s) {
        //  String sql = "delete from t_goods where id = ?,?";
        //return super.update(sql,s);
        //}
    }
}

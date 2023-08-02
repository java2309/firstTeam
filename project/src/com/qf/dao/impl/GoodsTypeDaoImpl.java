package com.qf.dao.impl;

import com.qf.dao.GoodsTypeDao;
import com.qf.entity.GoodsType;
import com.qf.util.BaseDao;

import java.util.List;

public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao {
    public List<GoodsType> SelectGoodsType(Integer page) {
        String sql = "select * from t_goodstype limit "+(page-1)*5+","+5;
        return super.query(sql, null, GoodsType.class);

    }

    public int GoodsTypeDelete(Object[] objects) {
        String sql = "delete from t_goodstype where id = ?";
        return super.update(sql, objects);
    }

    @Override
    public int GoodsTypeUpdate(Object[] objects) {
        String sql = "update t_goodstype set typename=? where id=?";
        return super.update(sql, objects);
    }

    @Override
    public List<GoodsType> SelectOneGoodsType(Object[] objects) {
        String sql = "select * from t_goodstype where id = ?";
        return super.query(sql, objects, GoodsType.class);
    }

    @Override
    public List<GoodsType> getGoodsTypeById(Integer id) {
        String sql = "select * from t_goodstype where id=?";
        Object[] objects = {id};
        List<GoodsType> query = super.query(sql, objects, GoodsType.class);
        return query;
    }

    @Override
    public int GoodsTypeAdd(Object[] objects) {
        String sql = "insert into t_goodstype(typename) values(?)";
        return super.update(sql, objects);

    }

    @Override
    public List<GoodsType> TypeSelect() {
        String sql = "select * from t_goodstype ";
        return super.query(sql, null, GoodsType.class);
    }

    public int SelectAllSize() {
        String sql = "select count(*) from t_goodstype";//查询所有的总条数
        int i = super.querySize(sql);
        return i;
    }
}




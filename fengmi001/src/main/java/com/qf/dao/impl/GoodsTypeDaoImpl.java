package com.qf.dao.impl;

import com.qf.dao.GoodsTypeDao;
import com.qf.entity.GoodsType;
import com.qf.utils.BaseDao;

import java.util.List;

public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao {
    @Override
    public List<GoodsType> TypeSelect() {
        String sql="select * from t_goodstype";
        return super.query(sql,null, GoodsType.class);
    }

    @Override
    public List<GoodsType> queryAllGoodsType(int pageNo, int pageSize) {
        String sql="select * from t_goodstype limit ?,?";
        Object[] objects={(pageNo-1)*pageSize,pageSize};
        return super.query(sql,objects, GoodsType.class);
    }

    @Override
    public int selectGoodsTypeCount() {
        String sql="select count(*) from t_goodstype";
        return super.selectCount(sql);
    }

    @Override
    public int delGoodsTypeById(int id) {
        String sql="delete from t_goodstype where id=?";
        Object[] objects={id};
        return super.update(sql,objects);
    }

    @Override
    public int addGoodsType(String typename) {
        String sql="insert into t_goodstype (typename) values (?)";
        Object[] objects={typename};
        return super.update(sql,objects);
    }

    @Override
    public GoodsType selectGoodsTypeById(int id) {
        String sql="select * from t_goodstype where id=?";
        Object[] objects={id};
        return super.query(sql,objects, GoodsType.class).get(0);
    }

    @Override
    public int updateGoodsType(String typename,int id) {
        String sql="update t_goodstype set typename=? where id=?";
        Object[] objects={typename,id};
        return super.update(sql,objects);
    }

    @Override
    public List<GoodsType> selectGoodsTypeByName(String typename) {
        String sql="select * from t_goodstype where typename=?";
        Object[] objects={typename};
        return super.query(sql,objects, GoodsType.class);
    }


}

package com.qf.dao;

import com.qf.entity.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> SelectGoods(Integer page);
    void GoodsDelete(Object[] objects);
  // int  batchDelete (String s);
    List<Goods> getGoodsById(Object[] objects);
    int GoodsAdd(Object[] objects);
    int GoodsUpdate(Object[] objects);
    int SelectAllSize();
}

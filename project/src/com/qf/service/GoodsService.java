package com.qf.service;

import com.qf.entity.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> SelectGoods(Integer page);
    void GoodsDelete(Object[] objects);
    //int  batchDelete (String s);
    Goods getGoodsById(Object[] objects);
    int GoodsAdd(Object[] objects);
    int GoodsUpdate(Object[] objects);
    int SelectLatest();
}

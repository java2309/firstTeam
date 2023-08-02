package com.qf.service;

import com.qf.entity.Goods;

import java.util.List;

public interface GoodsService {
    int selectGoodsCount(Goods goods);
    List<Goods> fuzzyQueryAllGoods(Goods goods,int pageNo, int pageSize);
    Boolean delGoods(int goodsId);
    int delGoodsByTypeId(int typeId);
    Goods getGoodsById(int id);
    Boolean addGoods(Object[] objects);
    Boolean updateGoods(Object[] objects);
    List<Goods> selectGoodsByTypeId(int typeId);
}

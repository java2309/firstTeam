package com.qf.dao;

import com.qf.entity.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> fuzzyQueryAllGoods(Goods goods,int pageNo, int pageSize);
    int selectGoodsCount(Goods goods);
    int delGoodsById(int id);
    int addGoods(Object[] objects);
    int delGoodsByTypeId(int typeId);
    Goods selectGoodsById(int id);
    int updateGoods(Object[] objects);
    List<Goods> selectGoodsByTypeId(int typeId);


}

package com.qf.dao;

import com.qf.entity.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    List<GoodsType> TypeSelect();
    List<GoodsType> queryAllGoodsType(int pageNo, int pageSize);
    int selectGoodsTypeCount();
    int delGoodsTypeById(int id);
    int addGoodsType(String typename);
    GoodsType selectGoodsTypeById(int id);
    int updateGoodsType(String typename, int id);
    List<GoodsType> selectGoodsTypeByName(String typeName);

}

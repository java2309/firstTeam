package com.qf.service;

import com.qf.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsType> TypeSelect();
    List<GoodsType> queryAllGoodsType(int pageNo, int pageSize);
    int selectGoodsTypeCount();
    Boolean delGoodsTypeById(int id);
    Boolean addGoodsType(String typename);
    GoodsType selectGoodsTypeById(int id);
    Boolean updateGoodsType(String typename,int id);
}

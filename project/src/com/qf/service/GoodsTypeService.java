package com.qf.service;

import com.qf.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsType> SelectGoodsType(Integer page);
    int GoodsTypeDelete(Object[] objects);
    int GoodsTypeUpdate(Object[] objects);
    List<GoodsType> SelectOneGoodsType(Object[] objects);
    List<GoodsType> getGoodsTypeById(Integer id);
    int GoodsTypeAdd(Object[] objects);

    List<GoodsType> TypeSelect();
    int SelectLatest();
}

package com.qf.service.impl;

import com.qf.dao.GoodsTypeDao;
import com.qf.dao.impl.GoodsTypeDaoImpl;
import com.qf.entity.GoodsType;
import com.qf.service.GoodsTypeService;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.List;

public  class GoodsTypeServiceImpl implements GoodsTypeService {
    GoodsTypeDao goodsTypeDao =new GoodsTypeDaoImpl();


    @Override
    public List<GoodsType> SelectGoodsType(Integer page) {
        List<GoodsType> goodsTypes = goodsTypeDao.SelectGoodsType(page);
        return goodsTypes;

    }

    @Override
    public int GoodsTypeDelete(Object[] objects) {
        int i = goodsTypeDao.GoodsTypeDelete(objects);
        return i;
    }

    @Override
    public int GoodsTypeUpdate(Object[] objects) {
        int i = goodsTypeDao.GoodsTypeUpdate(objects);
        return i;
    }

    @Override
    public List<GoodsType> SelectOneGoodsType(Object[] objects) {
        List<GoodsType> goodsTypes = goodsTypeDao.SelectOneGoodsType(objects);
        return goodsTypes;
    }

    @Override
    public List<GoodsType> getGoodsTypeById(Integer id) {
        List<GoodsType> goodsTypeById = goodsTypeDao.getGoodsTypeById(id);
        return goodsTypeById;
    }

    @Override
    public int GoodsTypeAdd(Object[] objects) {
        int i = goodsTypeDao.GoodsTypeAdd(objects);
        return i;
    }

    @Override
    public List<GoodsType> TypeSelect() {
        List<GoodsType> goodsTypes = goodsTypeDao.TypeSelect();
        return goodsTypes;
    }
    public int SelectLatest() {
        int size = goodsTypeDao.SelectAllSize();
        int page = size / 5;
        if (size % 5 == 0) {
            return page;
        }
        return page + 1;


    }
}



package com.qf.service.impl;

import com.qf.dao.GoodsDao;
import com.qf.dao.GoodsTypeDao;
import com.qf.dao.impl.GoodsDaoImpl;
import com.qf.dao.impl.GoodsTypeDaoImpl;
import com.qf.entity.GoodsType;
import com.qf.service.GoodsTypeService;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {
    GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImpl();
    GoodsDao goodsDao=new GoodsDaoImpl();

    @Override
    public List<GoodsType> TypeSelect() {
        return goodsTypeDao.TypeSelect();
    }

    @Override
    public List<GoodsType> queryAllGoodsType(int pageNo, int pageSize) {
        return goodsTypeDao.queryAllGoodsType(pageNo, pageSize);
    }

    @Override
    public int selectGoodsTypeCount() {
        return goodsTypeDao.selectGoodsTypeCount();
    }

    @Override
    public Boolean delGoodsTypeById(int id) {
        if (goodsDao.selectGoodsByTypeId(id)==null){
            return goodsTypeDao.delGoodsTypeById(id)==1;
        }else{
            return false;
        }

    }

    @Override
    public Boolean addGoodsType(String typename) {
        if (goodsTypeDao.selectGoodsTypeByName(typename)==null){
            return goodsTypeDao.addGoodsType(typename)==1;
        }else {
            return null;
        }

    }

    @Override
    public GoodsType selectGoodsTypeById(int id) {
        return goodsTypeDao.selectGoodsTypeById(id);
    }

    @Override
    public Boolean updateGoodsType(String typename, int id) {
        return goodsTypeDao.updateGoodsType(typename,id)==1;
    }
}

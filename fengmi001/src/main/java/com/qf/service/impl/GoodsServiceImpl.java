package com.qf.service.impl;

import com.qf.dao.GoodsDao;
import com.qf.dao.impl.GoodsDaoImpl;
import com.qf.entity.Goods;
import com.qf.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao=new GoodsDaoImpl();
    @Override
    public int selectGoodsCount(Goods goods) {
        return goodsDao.selectGoodsCount(goods);
    }

    @Override
    public List<Goods> fuzzyQueryAllGoods(Goods goods,int pageNo, int pageSize) {
        return goodsDao.fuzzyQueryAllGoods(goods,pageNo, pageSize);
    }

    @Override
    public Boolean delGoods(int goodsId) {
        return goodsDao.delGoodsById(goodsId)==1;
    }

    @Override
    public int delGoodsByTypeId(int typeId) {
        return goodsDao.delGoodsByTypeId(typeId);
    }

    @Override
    public Goods getGoodsById(int id) {
        return goodsDao.selectGoodsById(id);
    }
    public Boolean addGoods(Object[] objects){

        return goodsDao.addGoods(objects)==1;
    }

    @Override
    public Boolean updateGoods(Object[] objects) {
        return goodsDao.updateGoods(objects)==1;
    }

    @Override
    public List<Goods> selectGoodsByTypeId(int typeId) {
        return goodsDao.selectGoodsByTypeId(typeId);
    }
}

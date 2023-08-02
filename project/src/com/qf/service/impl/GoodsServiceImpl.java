package com.qf.service.impl;

import com.qf.dao.GoodsDao;
import com.qf.dao.GoodsTypeDao;
import com.qf.dao.impl.GoodsDaoImpl;
import com.qf.dao.impl.GoodsTypeDaoImpl;
import com.qf.entity.Goods;
import com.qf.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao =new GoodsDaoImpl();
    @Override
    public List<Goods> SelectGoods(Integer page) {
        List<Goods> goods = goodsDao.SelectGoods(page);
        return goods;
    }

    @Override
    public void GoodsDelete(Object[] objects) {
        goodsDao.GoodsDelete(objects);
    }

    @Override
    public Goods getGoodsById(Object[] objects) {
        List<Goods> goods = goodsDao.getGoodsById(objects);
        Goods goods1 = goods.get(0);
        return goods1;


    }


    @Override
    public int GoodsAdd(Object[] objects) {
        int i = goodsDao.GoodsAdd(objects);
        return i;
    }

    @Override
    public int GoodsUpdate(Object[] objects) {
        int i = goodsDao.GoodsUpdate(objects);
        return i;
    }
    public int SelectLatest() {
        int size = goodsDao.SelectAllSize();
        int page = size/5;
        if (size%5 == 0) {
            return page;
        }
        return page+1;
    }


    }

    // @Override
    //public int batchDelete(String s) {
      //  int i = goodsDao.batchDelete(s);
        //return i;
    //}

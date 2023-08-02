package com.qf.dao.impl;

import com.qf.dao.GoodsDao;
import com.qf.entity.Goods;
import com.qf.utils.BaseDao;

import java.text.SimpleDateFormat;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyy-MM-dd");
    @Override
    public List<Goods> fuzzyQueryAllGoods(Goods goods, int pageNo, int pageSize) {

        boolean flag=false;
        String goodsName="";
        String deployDate="";
        String typeId="";
        String sql1="select * from t_goods ";
        if (goods.getGoodsName()!=null){
            goodsName=" where goodsName like '%"+goods.getGoodsName()+"%' ";
            flag=true;
        }
        if (goods.getDeployDate()!=null){
            if (flag){
                deployDate=" and deployDate = '"+simpleDateFormat.format(goods.getDeployDate())+"' ";
            }else {
                deployDate=" where deployDate = '"+simpleDateFormat.format(goods.getDeployDate())+"' ";
                flag=true;
            }
        }
        if (goods.getTypeId()!=null){
            if (flag){
                typeId=" and typeId = '"+goods.getTypeId()+"' ";
            }else {
                typeId=" where typeId ='"+goods.getTypeId()+"' ";
                flag=true;
            }
        }
        String sql=sql1+goodsName+deployDate+typeId+" limit ?,?";
        Object[] objects={(pageNo-1)*pageSize,pageSize};
        return super.query(sql,objects, Goods.class);
    }
    @Override
    public int selectGoodsCount(Goods goods) {
        boolean flag=false;
        String goodsName="";
        String deployDate="";
        String typeId="";
        String sql1="select count(*) from t_goods ";
        if (goods.getGoodsName()!=null){
            goodsName=" where goodsName like '%"+goods.getGoodsName()+"%' ";
            flag=true;
        }
        if (goods.getDeployDate()!=null){
            if (flag){
                deployDate=" and deployDate = '"+simpleDateFormat.format(goods.getDeployDate())+"' ";
            }else {
                deployDate=" where deployDate = '"+simpleDateFormat.format(goods.getDeployDate())+"' ";
                flag=true;
            }
        }
        if (goods.getTypeId()!=null){
            if (flag){
                typeId=" and typeId = '"+goods.getTypeId()+"' ";
            }else {
                typeId=" where typeId ='"+goods.getTypeId()+"' ";
                flag=true;
            }
        }
        String sql=sql1+goodsName+deployDate+typeId;

        return super.selectCount(sql);
    }
    @Override
    public int delGoodsById(int goodId) {
        String sql="delete from t_goods where id=?";
        Object[] objects={goodId};
        return super.update(sql,objects);
    }
    @Override
    public int addGoods(Object[] objects) {
        String sql="insert into t_goods (goodsName,price,score,deployDate,typeId,imgPath,comment) values (?,?,?,?,?,?,?)";
        return super.update(sql,objects);
    }

    @Override
    public int delGoodsByTypeId(int typeId) {
        String sql="delete from t_goods where typeId=?";
        Object[] objects={typeId};
        return super.update(sql,objects);
    }

    @Override
    public Goods selectGoodsById(int id) {
        String sql="select * from t_goods where id=?";
        Object[] objects={id};
        return super.query(sql,objects, Goods.class).get(0);
    }
    @Override
    public int updateGoods(Object[] objects) {
        String sql="update t_goods set goodsName=?,price=?,score=?,typeId=?,imgPath=?,comment=? where id=?";
        return super.update(sql,objects);
    }

    @Override
    public List<Goods> selectGoodsByTypeId(int typeId) {
        String sql="select * from t_goods where typeId=?";
        Object[] objects={typeId};
        return super.query(sql,objects, Goods.class);
    }
}

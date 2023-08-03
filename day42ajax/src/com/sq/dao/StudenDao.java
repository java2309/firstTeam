package com.sq.dao;

import com.sq.entity.Studen;

import java.util.List;

public interface StudenDao {
    List<Studen> selectAllByName(String name,Integer limit,Integer pageSize);

    //删除
    int delStu(Integer id);
    //查询总数
    int selectSizeByName(String name);
    //修改
    int update(Object[] objs);
    //添加
    int add(Object[] objs);
}

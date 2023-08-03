package com.sq.service;

import com.sq.entity.Studen;
import com.sq.utils.BaseDao;

import java.util.List;

public interface StudentService {
    List<Studen> getAllStrudent(String name,Integer limit,Integer pageSize);
    //删除
    Boolean delStu(Integer id);
    //
    int selectSize(String name);
    //修改
    Boolean update(Object[] objs);
    //添加
    Boolean add(Object[] objs);
}

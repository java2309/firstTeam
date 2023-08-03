package com.qf.dao;

import com.qf.pojo.Passenger;


//查看一个旅客的国籍   旅客在一个张表    国籍在另外一张表
public interface PassengerDao {
    Passenger findById(Integer id);
}


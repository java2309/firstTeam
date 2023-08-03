package com.sq.dao;

import com.sq.pojo.Passenger;

public interface PassengerDao {
    //查看一个旅客的国籍
    //两表联查,通过id
    Passenger findById(Integer id);

}

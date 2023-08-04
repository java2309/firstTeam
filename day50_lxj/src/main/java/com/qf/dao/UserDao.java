package com.qf.dao;

import com.qf.entity.Passenger;

import java.util.List;

/**
 * @author 86185
 */
public interface UserDao {
    List<Passenger> selectById(Integer id);
}

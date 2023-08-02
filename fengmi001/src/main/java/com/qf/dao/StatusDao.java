package com.qf.dao;

import com.qf.entity.Status;

import java.util.List;

public interface StatusDao {
    Status selectStatusById(int id);
    List<Status> statusSelect();

}

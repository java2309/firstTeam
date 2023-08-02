package com.qf.service;

import com.qf.entity.Status;

import java.util.List;

public interface StatusService {
    Status selectStatusById(int id);
    List<Status> statusSelect();

}

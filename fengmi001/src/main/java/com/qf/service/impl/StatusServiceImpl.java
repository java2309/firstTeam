package com.qf.service.impl;

import com.qf.dao.StatusDao;
import com.qf.dao.impl.StatusDaoImpl;
import com.qf.entity.Status;
import com.qf.service.StatusService;

import java.util.List;

public class StatusServiceImpl implements StatusService {
    StatusDao statusDao=new StatusDaoImpl();
    @Override
    public Status selectStatusById(int id) {
        return statusDao.selectStatusById(id);
    }

    @Override
    public List<Status> statusSelect() {
        return statusDao.statusSelect();
    }
}

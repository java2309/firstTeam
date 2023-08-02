package com.qf.dao.impl;

import com.qf.dao.StatusDao;
import com.qf.entity.Status;
import com.qf.utils.BaseDao;

import java.util.List;

public class StatusDaoImpl extends BaseDao implements StatusDao {
    @Override
    public Status selectStatusById(int id) {
        String sql="select * from t_status where id=?";
        Object[] objects={id};
        return super.query(sql,objects,Status.class).get(0);
    }
    @Override
    public List<Status> statusSelect() {
        String sql="select * from t_status";
        return super.query(sql,null,Status.class);
    }
}

package com.qf.dao;

import com.qf.entity.Admin;

import java.util.List;

public interface AdminDao {
    List<Admin> selectByName(String name);
}

package com.sq.dao;

import com.sq.pojo.Department;

public interface DepartmentDao {
    //通过id查询部门
    Department findById(Integer id);
}

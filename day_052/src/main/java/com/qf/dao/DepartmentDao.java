package com.qf.dao;

import com.qf.pojo.Department;

public interface DepartmentDao {
    //通过id找到一个部门，下面还有员工属性
    Department findById(Integer id);
}

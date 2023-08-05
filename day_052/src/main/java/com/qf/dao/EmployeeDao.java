package com.qf.dao;

import com.qf.pojo.Employee;

public interface EmployeeDao {
    //通过id找到这个员工，还有他所属的部门
    Employee findById1(Integer id);
}

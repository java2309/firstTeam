package com.sq.service.Impl;

import com.sq.dao.Impl.StudenDaoImpl;
import com.sq.dao.StudenDao;
import com.sq.entity.Studen;
import com.sq.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudenDao studenDao = new StudenDaoImpl();
    @Override
    public List<Studen> getAllStrudent(String name,Integer limit,Integer pageSize) {
        List<Studen> students = studenDao.selectAllByName(name,limit,pageSize);
        return students;
    }

    @Override
    public Boolean delStu(Integer id) {
        int i = studenDao.delStu(id);
        if (i == 1){
           return true;
        }else {
            return false;
        }
    }

    @Override
    public int selectSize(String name) {
        int i = studenDao.selectSizeByName(name);
        return i;
    }

    @Override
    public Boolean update(Object[] objs) {
        int update = studenDao.update(objs);
        if (update == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean add(Object[] objs) {
        int add = studenDao.add(objs);
        if (add == 1){
            return true;
        }else {
            return false;
        }
    }
}

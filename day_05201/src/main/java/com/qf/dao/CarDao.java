package com.qf.dao;

import com.qf.pojo.Car;
import com.qf.vo.CarVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * description:
 * 公司:千锋教育
 * author:博哥
 * 公众号:Java架构栈
 */
public interface CarDao {
//    查询所有
    List<Car> findAll();
    //查询单个
      Car findById(@Param("id") Integer id);
     //根据条件查询
     List<Car> findCar(CarVo carVo);
    //修改@param car
    void update(Car car);
    void update1(Car car);
    //批量删除，数组
    void deleteByIds(@Param("wl") Integer[] ids);
    //批量删除，list集合
    void deleteByIds(@Param("wl") List<Integer> ids);
    //批量删除，其他集合
    void deleteByIds(@Param("wl") Set<Integer> ids);

}

package com.sq.dao;

import com.sq.pojo.Car;
import com.sq.vo.CarVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface CarDao {
        /**
         * 查询所有
         *
         * @return
         */
        List<Car> findAll();

        /**
         * 查询单个
         * @param id
         * @return
         */
        Car findById(@Param("id") Integer id);

        /**
         * 根据条件查询
         * @param carVo
         * @return
         */
        List<Car> findCar(CarVo carVo);

        /**
         * 修改
         * @param car
         */
        void update(Car car);
        void update1(Car car);
        /**
         * 批量删除
         * @param ids
         */
        //void deleteByIds(Integer [] ids);
        void deleteByIds(List<Integer> ids);
        //void deleteByIds(@Param("set") Set<Integer> ids);
}

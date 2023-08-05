package com.qf.pojo;

import lombok.Data;

/**
 * 如果对象涉及到IO流传以及缓存操作，必须实现序列化接口
 */

@Data
public class Car {

    private Integer id;
    private String name;
    private String brand;
    private Double price;
    private String color;
    private Integer num;

}
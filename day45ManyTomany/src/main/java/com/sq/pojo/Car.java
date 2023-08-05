package com.sq.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Car implements Serializable {
    private Integer id;
    private String name;
    private String brand;
    private Double price;
    private String color;
    private Integer num;


}

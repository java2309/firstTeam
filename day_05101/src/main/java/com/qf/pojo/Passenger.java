package com.qf.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Passenger {
    private Integer id;
    private String name;
    private String sex;
    private Date birthday;

    //护照对象  一个类的对象会作为另外一个类的属性看待
    //一个旅客对应这一个护照     我想要查看这个旅客的国籍

    private Passport passport;
}
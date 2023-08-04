package com.qf.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Passenger {
    private Integer id;
    private String name;
    private String sex;
    private Date birthday;
    private Passport passport;
}

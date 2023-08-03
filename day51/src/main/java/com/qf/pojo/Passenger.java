package com.qf.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Passenger {
    private Integer id;
    private String name;
    private String sex;
    private Date birthday;
    private Passport passport;
}

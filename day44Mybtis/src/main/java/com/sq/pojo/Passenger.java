package com.sq.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Passenger {
    private Integer id;
    private String name;
    private String sex;
    private Date birthDay;

    //护照对象
    private Passport passport;

}

package com.sq.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Passport {
    private Integer id;
    private String nationality;
    private Date expire;
}

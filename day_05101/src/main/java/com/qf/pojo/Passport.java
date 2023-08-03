package com.qf.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Passport {
    private Integer id;
    private String nationality;//国籍
    private Date expire;//日期
}

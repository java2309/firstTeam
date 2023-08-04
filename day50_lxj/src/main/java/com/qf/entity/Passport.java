package com.qf.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Passport {
    private Integer p_id;
    private String nationality;
    private Date expire;
    private Integer passenger_id;
}

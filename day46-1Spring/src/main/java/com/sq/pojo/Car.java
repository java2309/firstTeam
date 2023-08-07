package com.sq.pojo;

import lombok.Data;

@Data
public class Car {
    private Integer cid;
    private String cname;

    public Car(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }
}

package com.qf.entity;

import java.util.List;

//把这些东西兑成对象存起来，方便
public class R<T> {
    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;

    public R() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}


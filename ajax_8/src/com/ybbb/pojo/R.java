package com.ybbb.pojo;

import java.util.List;

public class R<T> {
    List<T> data;
    Integer code;
    String msg;
    Integer count;

    @Override
    public String toString() {
        return "R{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                '}';
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public R() {
    }
}

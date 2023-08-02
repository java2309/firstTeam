package com.qf.entity;

public class GoodsType {
    private Integer id;
    private String typename;
    private Integer level;
    private Integer pid;

    public GoodsType() {
    }

    public GoodsType(Integer id, String typename, Integer level, Integer pid) {
        this.id = id;
        this.typename = typename;
        this.level = level;
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", level=" + level +
                ", pid=" + pid +
                '}';
    }
}

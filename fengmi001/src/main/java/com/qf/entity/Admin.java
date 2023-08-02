package com.qf.entity;

public class Admin {
    private Integer id;
    private String username;
    private String password;
    private Integer role;

    public Admin() {
    }

    public Admin(String username, String password, Integer role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

}

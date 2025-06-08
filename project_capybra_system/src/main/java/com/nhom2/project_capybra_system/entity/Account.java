package com.nhom2.project_capybra_system.entity;

public class Account {
    private Integer id;
    private String username;
    private String password;
    private Integer roleId;
    private String token;
    private Boolean status;

    public Account(Integer id, String username, String password, Integer roleId, String token, Boolean status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.token = token;
        this.status = status;
    }

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.roleId = 1;
        this.token = null;
        this.status = true;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

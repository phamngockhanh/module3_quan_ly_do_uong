package com.nhom2.project_capybra_system.entity;

public class User {
    private Integer id;
    private String name;
    private Integer accountId;
    private String phone;
    private String address;
    private String email;
    private boolean status;

    public User() {
    }

    public User(Integer id, String name, Integer accountId, String phone, String address, String email, boolean status) {
        this.id = id;
        this.name = name;
        this.accountId = accountId;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.status = status;
    }

    public User(String name, Integer accountId, String phone, String address, String email) {
        this.name = name;
        this.accountId = accountId;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.status = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

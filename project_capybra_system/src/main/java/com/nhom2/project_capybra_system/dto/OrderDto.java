package com.nhom2.project_capybra_system.dto;

import java.util.Date;

public class OrderDto {
    private int userId;
    private String name;
    private String email;
    private String address;
    private int accountId;
    private int orderId;
    private Date orderDate;
    private int orderStatusId;

    public OrderDto() {
    }

    public OrderDto(int userId, String name, String email, String address, int accountId,
                    int orderId, Date orderDate, int orderStatusId) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.accountId = accountId;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderStatusId = orderStatusId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }
}

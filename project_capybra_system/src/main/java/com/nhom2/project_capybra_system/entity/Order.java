package com.nhom2.project_capybra_system.entity;

import java.util.Date;

public class Order {
    private Integer id;
    private Integer userId;
    private Date date;
    private Integer orderStatusId;

    public Order() {
    }

    public Order(Integer id, Integer userId, Date date, Integer orderStatusId) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.orderStatusId = orderStatusId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }
}

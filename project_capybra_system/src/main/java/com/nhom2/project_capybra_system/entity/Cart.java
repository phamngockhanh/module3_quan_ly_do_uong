package com.nhom2.project_capybra_system.entity;


import java.util.Date;

public class Cart {
    private Integer id;
    private Date date;
    private Boolean status;

    public Cart() {
    }

    public Cart(Integer id, Date date, Boolean status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

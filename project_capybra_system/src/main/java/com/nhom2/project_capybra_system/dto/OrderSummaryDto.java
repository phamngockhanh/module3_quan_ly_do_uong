package com.nhom2.project_capybra_system.dto;

import java.util.Date;

public class OrderSummaryDto {
    private int orderId;
    private Date orderDate;
    private int totalQuantity;
    private String status;
    private int totalPrice;

    public OrderSummaryDto(int orderId, Date orderDate, int totalQuantity, String status,int totalPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalQuantity = totalQuantity;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public int getTotalQuantity() { return totalQuantity; }
    public void setTotalQuantity(int totalQuantity) { this.totalQuantity = totalQuantity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}

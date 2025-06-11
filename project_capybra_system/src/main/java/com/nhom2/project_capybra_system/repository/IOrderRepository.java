package com.nhom2.project_capybra_system.repository;

import com.nhom2.project_capybra_system.dto.OrderSummaryDto;
import com.nhom2.project_capybra_system.entity.Order;

import java.util.List;

public interface IOrderRepository extends IRepository<Order> {
    void placeOrder( int userId, String[] productIds, String[] quantities, int cartId);
    List<OrderSummaryDto> getOrderSummariesByUserId(int userId);
}

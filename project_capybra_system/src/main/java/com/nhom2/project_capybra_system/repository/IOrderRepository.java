package com.nhom2.project_capybra_system.repository;

import com.nhom2.project_capybra_system.dto.OrderDto;
import com.nhom2.project_capybra_system.dto.OrderSummaryDto;
import com.nhom2.project_capybra_system.entity.Order;

import java.util.List;

public interface IOrderRepository extends IRepository<Order> {
    List<OrderDto> findAllByNameAndStatusId(String name, int statusId);
    void placeOrder( int userId, String[] productIds, String[] quantities, int cartId);
    List<OrderSummaryDto> getOrderSummariesByUserId(int userId);
}

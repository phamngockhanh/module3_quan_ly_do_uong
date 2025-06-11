package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.dto.OrderSummaryDto;
import com.nhom2.project_capybra_system.entity.Order;
import com.nhom2.project_capybra_system.repository.IOrderRepository;
import com.nhom2.project_capybra_system.repository.impl.OrderRepository;
import com.nhom2.project_capybra_system.service.IOrderService;

import java.util.List;

public class OrderService implements IOrderService {
    private IOrderRepository repository = new OrderRepository();

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void placeOrder(int userId, String[] productIds, String[] quantities, int cartId) {
        repository.placeOrder(userId,productIds,quantities,cartId);
    }

    @Override
    public List<OrderSummaryDto> getOrderSummariesByUserId(int userId) {
        return repository.getOrderSummariesByUserId(userId);
    }
}

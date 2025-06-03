package com.nhom2.project_capybra_system.service.impl;

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
    public Order findById(Integer id) {
        return null;
    }
}

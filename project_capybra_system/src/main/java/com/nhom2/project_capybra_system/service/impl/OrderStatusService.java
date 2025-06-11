package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.OrderStatus;
import com.nhom2.project_capybra_system.repository.IOrderStatusRepository;
import com.nhom2.project_capybra_system.repository.impl.OrderStatusRepository;
import com.nhom2.project_capybra_system.service.IOrderStatusService;

import java.util.List;

public class OrderStatusService implements IOrderStatusService {
    private IOrderStatusRepository repository = new OrderStatusRepository();

    @Override
    public List<OrderStatus> findAll() {
        return repository.findAll();
    }

    @Override
    public OrderStatus findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}

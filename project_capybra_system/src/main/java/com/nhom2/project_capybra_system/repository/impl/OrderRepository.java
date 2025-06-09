package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.entity.Order;
import com.nhom2.project_capybra_system.repository.IOrderRepository;

import java.util.List;

public class OrderRepository implements IOrderRepository {
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
}

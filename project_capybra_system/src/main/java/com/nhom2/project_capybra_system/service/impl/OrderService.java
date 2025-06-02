package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.repository.IOrderRepository;
import com.nhom2.project_capybra_system.repository.impl.OrderRepository;
import com.nhom2.project_capybra_system.service.IOrderService;

public class OrderService implements IOrderService {
    private IOrderRepository repository = new OrderRepository();
}

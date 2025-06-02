package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.repository.IOrderStatusRepository;
import com.nhom2.project_capybra_system.repository.impl.OrderStatusRepository;
import com.nhom2.project_capybra_system.service.IOrderStatusService;

public class OrderStatusService implements IOrderStatusService {
    private IOrderStatusRepository repository = new OrderStatusRepository();
}

package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.repository.IOrderDetailRepository;
import com.nhom2.project_capybra_system.repository.impl.OrderDetailRepository;
import com.nhom2.project_capybra_system.service.IOrderDetailService;

public class OrderDetailService implements IOrderDetailService {
    private IOrderDetailRepository repository = new OrderDetailRepository();
}

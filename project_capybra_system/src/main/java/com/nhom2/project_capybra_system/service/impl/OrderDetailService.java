package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.OrderDetail;
import com.nhom2.project_capybra_system.repository.IOrderDetailRepository;
import com.nhom2.project_capybra_system.repository.impl.OrderDetailRepository;
import com.nhom2.project_capybra_system.service.IOrderDetailService;

import java.util.List;

public class OrderDetailService implements IOrderDetailService {
    private IOrderDetailRepository repository = new OrderDetailRepository();

    @Override
    public List<OrderDetail> findAll() {
        return null;
    }

    @Override
    public OrderDetail findById(int id) {
        return null;
    }

}

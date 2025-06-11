package com.nhom2.project_capybra_system.service;

import com.nhom2.project_capybra_system.dto.OrderDto;
import com.nhom2.project_capybra_system.entity.Order;

import java.util.List;

public interface IOrderService extends IService<Order> {
    List<OrderDto> findAllByNameAndStatusId(String name, int statusId);
}

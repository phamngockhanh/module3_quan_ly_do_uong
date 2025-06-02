package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.repository.ICartDetailRepository;
import com.nhom2.project_capybra_system.repository.impl.CartDetailRepository;
import com.nhom2.project_capybra_system.service.ICartDetailService;

public class CartDetailService implements ICartDetailService {
    private ICartDetailRepository repository = new CartDetailRepository();
}


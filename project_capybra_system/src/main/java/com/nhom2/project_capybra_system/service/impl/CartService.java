package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.repository.ICartRepository;
import com.nhom2.project_capybra_system.repository.impl.CartRepository;
import com.nhom2.project_capybra_system.service.ICartService;

public class CartService implements ICartService {
    private ICartRepository repository = new CartRepository();
}

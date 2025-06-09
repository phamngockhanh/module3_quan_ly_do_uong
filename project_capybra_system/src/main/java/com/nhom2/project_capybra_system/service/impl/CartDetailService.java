package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.CartDetail;
import com.nhom2.project_capybra_system.repository.ICartDetailRepository;
import com.nhom2.project_capybra_system.repository.impl.CartDetailRepository;
import com.nhom2.project_capybra_system.service.ICartDetailService;

import java.util.List;

public class CartDetailService implements ICartDetailService {
    private ICartDetailRepository repository = new CartDetailRepository();

    @Override
    public List<CartDetail> findAll() {
        return null;
    }

    @Override
    public CartDetail findById(int id) {
        return null;
    }

}


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

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void updateCartDetail(int cartId, int productId, int quantity) {
        repository.updateCartDetail(cartId,productId,quantity);
    }

    @Override
    public void insertCartDetail(int cartId, int productId, int quantity) {
        repository.insertCartDetail(cartId,productId,quantity);
    }

    @Override
    public boolean existsCartDetail(int cartId, int productId) {
        return repository.existsCartDetail(cartId,productId);
    }

    @Override
    public int getQuantity(int cartId, int productId) {
        return repository.getQuantity(cartId,productId);
    }
}


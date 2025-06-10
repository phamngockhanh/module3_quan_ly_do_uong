package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.Cart;
import com.nhom2.project_capybra_system.repository.ICartRepository;
import com.nhom2.project_capybra_system.repository.impl.CartRepository;
import com.nhom2.project_capybra_system.service.ICartService;

import java.util.List;
import java.util.Map;

public class CartService implements ICartService {
    private ICartRepository repository = new CartRepository();

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public Cart findById(int id) {
        return null;
    }


    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void addByAccountId(Integer userId) {
        Cart cart = new Cart(userId);
        repository.add(cart);
    }

    @Override
    public Map<Integer, Integer> getUserCart(int userId) {
        return  repository.getUserCart(userId);
    }

    @Override
    public int getCartId(int userId) {
        return repository.getCartId(userId);
    }
}

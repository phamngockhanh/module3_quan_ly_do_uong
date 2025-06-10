package com.nhom2.project_capybra_system.repository;

import com.nhom2.project_capybra_system.entity.Cart;

import java.util.Map;

public interface ICartRepository extends IRepository<Cart> {
    Boolean add (Cart cart);
    Map<Integer, Integer> getUserCart(int userId);
    int getCartId(int userId);
}

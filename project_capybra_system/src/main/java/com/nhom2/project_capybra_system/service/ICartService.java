package com.nhom2.project_capybra_system.service;

import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.entity.Cart;

import java.util.Map;

public interface ICartService extends IService<Cart> {
    void addByAccountId(Integer id);
    Map<Integer, Integer> getUserCart(int userId);
    int getCartId(int userId);

}

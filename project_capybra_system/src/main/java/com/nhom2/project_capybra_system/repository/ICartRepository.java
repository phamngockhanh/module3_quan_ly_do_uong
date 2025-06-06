package com.nhom2.project_capybra_system.repository;

import com.nhom2.project_capybra_system.entity.Cart;

public interface ICartRepository extends IRepository<Cart> {
    Boolean add (Cart cart);
}

package com.nhom2.project_capybra_system.service;

import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.entity.CartDetail;

public interface ICartDetailService  extends IService<CartDetail> {
    void updateCartDetail(int cartId,int productId, int quantity);
    void insertCartDetail(int cartId,int productId, int quantity);
    boolean existsCartDetail(int cartId, int productId);
    int getQuantity(int cartId, int productId);
}

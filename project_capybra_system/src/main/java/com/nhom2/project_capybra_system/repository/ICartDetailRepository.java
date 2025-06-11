package com.nhom2.project_capybra_system.repository;

import com.nhom2.project_capybra_system.entity.CartDetail;

public interface ICartDetailRepository extends IRepository<CartDetail>{
    void updateCartDetail(int cartId,int productId, int quantity);
    void insertCartDetail(int cartId,int productId, int quantity);
    boolean existsCartDetail(int cartId, int productId);
    int getQuantity(int cartId, int productId);
    boolean  deleteCartDetail(int cartId, int productId);
}

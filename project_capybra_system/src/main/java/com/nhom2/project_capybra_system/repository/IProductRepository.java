package com.nhom2.project_capybra_system.repository;

import com.nhom2.project_capybra_system.entity.Product;

import java.util.List;

public interface IProductRepository extends IRepository<Product> {
    int countProduct();
    int countProductWithFilter(String productName, int categoryId);
    List<Product> findAllWithPagination(String productName, int categoryId,int offset, int pageSize);
    List<Product> findAllNoneFilter(int offset, int pageSize);
}

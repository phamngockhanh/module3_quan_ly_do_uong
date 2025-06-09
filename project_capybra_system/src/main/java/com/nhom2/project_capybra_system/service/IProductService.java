package com.nhom2.project_capybra_system.service;

import com.nhom2.project_capybra_system.entity.Product;

import java.util.List;

public interface IProductService extends IService<Product> {
    int countProduct();
    int countProductWithFilter(String productName, int categoryId);
    List<Product> findAllWithPagination(String productName, int categoryId, int offset, int pageSize);
    List<Product> findAllNoneFilter(int offset, int pageSize);
    boolean add(Product product);
    boolean update(Product product);
}

package com.nhom2.project_capybra_system.service;

import com.nhom2.project_capybra_system.entity.Product;

public interface IProductService extends IService<Product> {
    boolean add(Product product);
    boolean update(Product product);
}

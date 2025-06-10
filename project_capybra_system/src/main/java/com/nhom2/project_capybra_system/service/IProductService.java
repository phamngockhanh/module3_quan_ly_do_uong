package com.nhom2.project_capybra_system.service;

import com.nhom2.project_capybra_system.entity.Product;

import java.util.List;

public interface IProductService extends IService<Product> {
    boolean add(Product product);
    boolean update(Product product);
    List<Product> search(String name, Integer id);
}

package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.Product;
import com.nhom2.project_capybra_system.repository.IProductRepository;
import com.nhom2.project_capybra_system.repository.impl.ProductRepository;
import com.nhom2.project_capybra_system.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository repository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }
}

package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.repository.IProductRepository;
import com.nhom2.project_capybra_system.repository.impl.ProductRepository;
import com.nhom2.project_capybra_system.service.IProductService;

public class ProductService implements IProductService {
    private IProductRepository repository = new ProductRepository();
}

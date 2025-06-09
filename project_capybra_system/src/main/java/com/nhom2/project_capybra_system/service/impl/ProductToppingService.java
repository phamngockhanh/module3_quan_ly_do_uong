package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.ProductTopping;
import com.nhom2.project_capybra_system.repository.IProductToppingRepository;
import com.nhom2.project_capybra_system.repository.impl.ProductToppingRepository;
import com.nhom2.project_capybra_system.service.IProductToppingService;

import java.util.List;

public class ProductToppingService implements IProductToppingService {
    private IProductToppingRepository repository = new ProductToppingRepository();

    @Override
    public List<ProductTopping> findAll() {
        return null;
    }

    @Override
    public ProductTopping findById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}

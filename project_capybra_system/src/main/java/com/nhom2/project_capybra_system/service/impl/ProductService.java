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
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return  repository.delete(id);
    }

    @Override
    public boolean add(Product product) {
        return repository.add(product);
    }
 public boolean update(Product product){
        return repository.update(product);

    }
}

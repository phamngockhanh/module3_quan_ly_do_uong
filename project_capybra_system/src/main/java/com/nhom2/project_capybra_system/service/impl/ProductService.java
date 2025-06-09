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
    public int countProduct() {
        return repository.countProduct();
    }

    @Override
    public int countProductWithFilter(String productName, int categoryId) {
        return repository.countProductWithFilter(productName,categoryId);
    }

    @Override
    public List<Product> findAllWithPagination(String productName, int categoryId, int offset, int pageSize) {
        return repository.findAllWithPagination(productName,categoryId,offset,pageSize);
    }

    @Override
    public List<Product> findAllNoneFilter(int offset, int pageSize) {
        return repository.findAllNoneFilter(offset,pageSize);
    }
}

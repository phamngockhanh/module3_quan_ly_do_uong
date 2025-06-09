package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.Category;
import com.nhom2.project_capybra_system.repository.ICategoryRepository;
import com.nhom2.project_capybra_system.repository.impl.CategoryRepository;
import com.nhom2.project_capybra_system.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepository repository = new CategoryRepository();

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}

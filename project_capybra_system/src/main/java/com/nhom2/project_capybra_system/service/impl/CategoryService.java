package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.repository.ICategoryRepository;
import com.nhom2.project_capybra_system.repository.impl.CategoryRepository;
import com.nhom2.project_capybra_system.service.ICategoryService;

public class CategoryService implements ICategoryService {
    private ICategoryRepository repository = new CategoryRepository();
}

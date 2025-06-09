package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.Topping;
import com.nhom2.project_capybra_system.repository.IToppingRepository;
import com.nhom2.project_capybra_system.repository.impl.ToppingRepository;
import com.nhom2.project_capybra_system.service.IToppingService;

import java.util.List;

public class ToppingService implements IToppingService {
    private IToppingRepository repository = new ToppingRepository();

    @Override
    public List<Topping> findAll() {
        return null;
    }

    @Override
    public Topping findById(int id) {
        return null;
    }
}

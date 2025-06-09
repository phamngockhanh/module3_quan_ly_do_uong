package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.Role;
import com.nhom2.project_capybra_system.repository.IRoleRepository;
import com.nhom2.project_capybra_system.repository.impl.RoleRepository;
import com.nhom2.project_capybra_system.service.IRoleService;

import java.util.List;

public class RoleService implements IRoleService {
    private IRoleRepository repository = new RoleRepository();

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}

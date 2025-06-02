package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.repository.IRoleRepository;
import com.nhom2.project_capybra_system.repository.impl.RoleRepository;
import com.nhom2.project_capybra_system.service.IRoleService;

public class RoleService implements IRoleService {
    private IRoleRepository repository = new RoleRepository();
}

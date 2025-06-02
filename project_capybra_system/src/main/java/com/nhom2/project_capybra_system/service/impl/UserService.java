package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.repository.IUserRepository;
import com.nhom2.project_capybra_system.repository.impl.UserRepository;
import com.nhom2.project_capybra_system.service.IUserService;

public class UserService implements IUserService {
    private IUserRepository repository = new UserRepository();
}

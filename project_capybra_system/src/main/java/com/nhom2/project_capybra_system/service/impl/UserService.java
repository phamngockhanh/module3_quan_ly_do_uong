package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.User;
import com.nhom2.project_capybra_system.repository.IUserRepository;
import com.nhom2.project_capybra_system.repository.impl.UserRepository;
import com.nhom2.project_capybra_system.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository repository = new UserRepository();

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }
}

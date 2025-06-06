package com.nhom2.project_capybra_system.service;

import com.nhom2.project_capybra_system.entity.User;

public interface IUserService extends IService<User> {
    void addUserWithAccount(String username, String name, String phone, String address, String email);
}

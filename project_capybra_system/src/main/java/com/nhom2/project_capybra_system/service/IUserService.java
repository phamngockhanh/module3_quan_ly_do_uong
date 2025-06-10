package com.nhom2.project_capybra_system.service;

import com.nhom2.project_capybra_system.dto.UserDto;
import com.nhom2.project_capybra_system.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {
    void addUserWithAccount(String username, String name, String phone, String address, String email);

    List<UserDto> findAllUserAndAccount();

    UserDto findUserAndAccountByUserId(int id);

    UserDto findUserAndAccountByAccountId(int id);

    User findByUsername(String username);

    boolean updateUser(User user);
}

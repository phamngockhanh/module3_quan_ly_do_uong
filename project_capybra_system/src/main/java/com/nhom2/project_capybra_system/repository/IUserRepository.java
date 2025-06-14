package com.nhom2.project_capybra_system.repository;

import com.nhom2.project_capybra_system.dto.UserDto;
import com.nhom2.project_capybra_system.entity.User;

import java.util.List;

public interface IUserRepository extends IRepository<User> {
    void add(User user);

    List<UserDto> findAllUserAndAccount();

    UserDto findUserAndAccountByUserId(int id);

    UserDto findUserAndAccountByAccountId(int id);

    User findByUsername(String username);

    boolean updateUser(User user);

    int getUserId(int accountId);

    List<UserDto> findAllUserAndAccountByNameAndAccountStatus(String findName, int findStatus);
}

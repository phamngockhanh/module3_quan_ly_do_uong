package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.dto.UserDto;
import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.entity.User;
import com.nhom2.project_capybra_system.repository.IUserRepository;
import com.nhom2.project_capybra_system.repository.impl.UserRepository;
import com.nhom2.project_capybra_system.service.IAccountService;
import com.nhom2.project_capybra_system.service.ICartService;
import com.nhom2.project_capybra_system.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository repository = new UserRepository();
    private IAccountService accountService = new AccountService();
    private ICartService cartService = new CartService();

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }


    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void addUserWithAccount(String username, String name, String phone, String address, String email) {
        Account account = accountService.findByUsername(username);
        User user = new User(name, account.getId() , phone,address, email);
        repository.add(user);

    }

    @Override
    public List<UserDto> findAllUserAndAccount() {
        return repository.findAllUserAndAccount();
    }

    @Override
    public UserDto findUserAndAccountByUserId(int id) {
        return repository.findUserAndAccountByUserId(id);
    }

    @Override
    public UserDto findUserAndAccountByAccountId(int id) {
        return repository.findUserAndAccountByAccountId(id);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public boolean updateUser(User user) {
        return repository.updateUser(user);
    }


}

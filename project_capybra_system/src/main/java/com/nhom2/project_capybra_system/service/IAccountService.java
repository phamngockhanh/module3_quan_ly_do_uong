package com.nhom2.project_capybra_system.service;

import com.nhom2.project_capybra_system.entity.Account;

public interface IAccountService extends IService<Account> {
    Account findByUsername(String username);

    void add(Account account);

    Account checkLogin(String username, String password);
}

package com.nhom2.project_capybra_system.repository;

import com.nhom2.project_capybra_system.entity.Account;

public interface IAccountRepository extends IRepository<Account>{
    Account findByUsername(String username);
    void add(Account account);
}

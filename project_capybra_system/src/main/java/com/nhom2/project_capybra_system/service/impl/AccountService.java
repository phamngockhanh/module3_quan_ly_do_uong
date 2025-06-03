package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.repository.IAccountRepository;
import com.nhom2.project_capybra_system.repository.impl.AccountRepository;
import com.nhom2.project_capybra_system.service.IAccountService;

import java.util.List;

public class AccountService implements IAccountService {
    private IAccountRepository repository = new AccountRepository();

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(Integer id) {
        return null;
    }
}

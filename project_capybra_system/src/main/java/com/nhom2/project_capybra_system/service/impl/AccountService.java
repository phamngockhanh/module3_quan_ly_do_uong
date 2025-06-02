package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.repository.IAccountRepository;
import com.nhom2.project_capybra_system.repository.impl.AccountRepository;
import com.nhom2.project_capybra_system.service.IAccountService;

public class AccountService implements IAccountService {
    private IAccountRepository repository = new AccountRepository();
}

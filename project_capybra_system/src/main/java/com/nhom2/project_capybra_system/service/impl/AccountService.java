package com.nhom2.project_capybra_system.service.impl;

import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.repository.IAccountRepository;
import com.nhom2.project_capybra_system.repository.impl.AccountRepository;
import com.nhom2.project_capybra_system.service.IAccountService;
import com.nhom2.project_capybra_system.util.PasswordEncodeUtil;

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

    @Override
    public Account findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void add(Account account) {
        String encodePassword = PasswordEncodeUtil.encode(account.getPassword());
        account.setPassword(encodePassword);
        repository.add(account);
    }

    @Override
    public Account checkLogin(String username, String password) {
        Account account = repository.findByUsername(username);
        if(account != null && PasswordEncodeUtil.check(password, account.getPassword())){
            account.setPassword(null);
            return account;
        }
        return null;
    }
}

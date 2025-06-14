package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.repository.IAccountRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountRepository implements IAccountRepository {

    private static final String DISABLE_ACCOUNT_BY_USERNAME = "update accounts set status = 0 where username = ?";
    private static final String UNLOCK_ACCOUNT_BY_USERNAME = "update accounts set status = 1 where username = ?";
    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(int id) {
        return null;
    }


    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Account findByUsername(String username) {
        String sql = "select * from accounts where username = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                account.setToken(resultSet.getString("token"));
                account.setStatus(resultSet.getBoolean("status"));
                account.setRoleId(resultSet.getInt("role_id"));
                return account;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void add(Account account) {
        String sql = "insert into accounts (username, password, token, status, role_id)" +
                "values (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getToken());
            statement.setBoolean(4, account.getStatus());
            statement.setInt(5, account.getRoleId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean disableAccountByUsername(String username) {
        try (Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(DISABLE_ACCOUNT_BY_USERNAME)){
            statement.setString(1, username);
            int updatedRow = statement.executeUpdate();
            return updatedRow == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean unlockAccountByUsername(String username) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UNLOCK_ACCOUNT_BY_USERNAME)){
            statement.setString(1, username);
            int updatedRow = statement.executeUpdate();
            return updatedRow == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

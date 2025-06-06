package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.entity.User;
import com.nhom2.project_capybra_system.repository.IUserRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public void add(User user) {
        String sql = "insert into users (name, account_id, phone, address, email, status) " +
                "values (?,?,?,?,?,?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getName());
            statement.setInt(2, user.getAccountId());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getEmail());
            statement.setBoolean(6, user.isStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

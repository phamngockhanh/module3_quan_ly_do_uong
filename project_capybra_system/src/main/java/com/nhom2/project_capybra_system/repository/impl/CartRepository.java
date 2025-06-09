package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.entity.Cart;
import com.nhom2.project_capybra_system.repository.ICartRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CartRepository implements ICartRepository {
    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public Cart findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }



    @Override
    public Boolean add(Cart cart) {
        String sql = "insert into carts (user_id,status) values (? , ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, cart.getUserId());
            statement.setBoolean(2, cart.getStatus());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

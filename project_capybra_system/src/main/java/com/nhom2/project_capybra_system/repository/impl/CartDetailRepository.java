package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.entity.Cart;
import com.nhom2.project_capybra_system.entity.CartDetail;
import com.nhom2.project_capybra_system.repository.ICartDetailRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartDetailRepository implements ICartDetailRepository {
    private static final String UPDATE_CART_DETAIL = "update cart_details set quantity =quantity + ? where product_id =? and cart_id = ?;";
    private static final String INSERT_CART_DETAIL = "insert into cart_details (cart_id,product_id,quantity) values (?,?,?);";
    @Override
    public List<CartDetail> findAll() {
        return null;
    }

    @Override
    public CartDetail findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


    @Override
    public void updateCartDetail(int cartId, int productId, int quantity) {
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(UPDATE_CART_DETAIL)){
            preparedStatement.setInt(1,quantity);
            preparedStatement.setInt(2,productId);
            preparedStatement.setInt(3,cartId);
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void insertCartDetail(int cartId, int productId, int quantity) {
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_DETAIL)){
            preparedStatement.setInt(1,cartId);
            preparedStatement.setInt(2,productId);
            preparedStatement.setInt(3,quantity);
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}

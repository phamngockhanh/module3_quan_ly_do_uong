package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.entity.Cart;
import com.nhom2.project_capybra_system.repository.ICartRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CartRepository implements ICartRepository {
    private static final String SELECT_CART_ID = "SELECT id FROM Carts WHERE user_id = ?;";
    private static final String FIND_PRODUCT_ID_QUANTITY = "SELECT product_id, quantity FROM cart_details WHERE cart_id = ?;";
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

    @Override
    public Map<Integer, Integer> getUserCart(int userId) {
        Map<Integer,Integer> userCart = new HashMap<>();
        int cartId = -1;
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_ID)){
            preparedStatement.setInt(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                cartId = resultSet.getInt("id");
            }

            if(cartId == -1){
                return userCart;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_ID_QUANTITY)){
            preparedStatement.setInt(1,cartId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int productId = resultSet.getInt("product_id");
                int quantity = resultSet.getInt("quantity");
                userCart.put(productId,quantity);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return userCart;
    }

    @Override
    public int getCartId(int userId) {
        int cartId = -1;
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_ID)){
            preparedStatement.setInt(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                cartId = resultSet.getInt("id");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return cartId;
    }
}

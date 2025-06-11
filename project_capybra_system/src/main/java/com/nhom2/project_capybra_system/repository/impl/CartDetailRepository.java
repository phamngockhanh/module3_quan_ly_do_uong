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
    private static final String UPDATE_CART_DETAIL = "update cart_details set quantity = ? where product_id =? and cart_id = ?;";
    private static final String INSERT_CART_DETAIL = "insert into cart_details (cart_id,product_id,quantity) values (?,?,?);";
    private static final String CHECK_EXISTED_PRODUCT = "SELECT COUNT(*) FROM cart_details WHERE cart_id = ? AND product_id = ?;";
    private static final String GET_QUANTITY = "SELECT quantity FROM cart_details WHERE cart_id = ? AND product_id = ?;";
    private static final String DELETE_CART_DETAIL = "delete from cart_details where cart_id = ? AND product_id = ?;";
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

    @Override
    public boolean existsCartDetail(int cartId, int productId) {
        try (Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CHECK_EXISTED_PRODUCT)){
            preparedStatement.setInt(1,cartId);
            preparedStatement.setInt(2,productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1) > 0;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int getQuantity(int cartId, int productId) {
        int quantity = -1;
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_QUANTITY)){
            preparedStatement.setInt(1,cartId);
            preparedStatement.setInt(2,productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                quantity = resultSet.getInt("quantity");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return quantity;
    }

    @Override
    public boolean  deleteCartDetail(int cartId, int productId) {
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_DETAIL)){
            preparedStatement.setInt(1,cartId);
            preparedStatement.setInt(2,productId);
            int affectRows = preparedStatement.executeUpdate();
            return  affectRows>0;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

}

package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.entity.Product;
import com.nhom2.project_capybra_system.repository.IProductRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String SELECT_ALL = "select * from products";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getLong("price"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setStatus(resultSet.getBoolean("status"));
                product.setDescription(resultSet.getString("description"));
                product.setImage(resultSet.getString("image"));

                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        String DELETE_ID="delete from products where id=?;";
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement(DELETE_ID);) {
          preparedStatement.setInt(1,id);
           int effectRow = preparedStatement.executeUpdate();
           return effectRow==1;
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
        }

        return false;
    }
//    public boolean add(Product product) throws SQLException {
//        String ADD="insert into products(name,price,category_id,status,description,image,size) value(?,?,?,?,?,?,?);";
//        try(Connection connection=DatabaseUtil.getConnection();
//        PreparedStatement preparedStatement= connection.prepareStatement(ADD);){
//            preparedStatement.setString(1,product.getName());
//            preparedStatement.setInt(2,product.getCategoryId());
//            preparedStatement.setString(3,product.getStatus());
//            preparedStatement.setString(4,product.getDescription());
//            preparedStatement.setString(5,product.getImage());
//        }
//    }



}

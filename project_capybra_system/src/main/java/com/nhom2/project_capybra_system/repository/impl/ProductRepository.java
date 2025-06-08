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
        String query = "select * from products";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
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
    public Product findById(Integer id) {
        return null;
    }
}

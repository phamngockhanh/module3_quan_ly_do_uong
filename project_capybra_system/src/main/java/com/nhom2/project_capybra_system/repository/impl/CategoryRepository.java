package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.entity.Category;
import com.nhom2.project_capybra_system.repository.ICategoryRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private static final String SELECT_ALL_CATEGORY = "select * from categories";

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}

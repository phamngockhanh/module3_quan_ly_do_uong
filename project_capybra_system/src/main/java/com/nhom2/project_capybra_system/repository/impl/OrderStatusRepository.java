package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.dto.OrderDto;
import com.nhom2.project_capybra_system.entity.OrderStatus;
import com.nhom2.project_capybra_system.repository.IOrderStatusRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderStatusRepository implements IOrderStatusRepository {

    private static final String FIND_ALL = "select * from order_status";

    @Override
    public List<OrderStatus> findAll() {
        List<OrderStatus> orderStatuses = new ArrayList<>();
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()){
                OrderStatus orderStatus = new OrderStatus();
                orderStatus.setId(resultSet.getInt("id"));
                orderStatus.setName(resultSet.getString("name"));

                orderStatuses.add(orderStatus);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderStatuses;
    }

    @Override
    public OrderStatus findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}
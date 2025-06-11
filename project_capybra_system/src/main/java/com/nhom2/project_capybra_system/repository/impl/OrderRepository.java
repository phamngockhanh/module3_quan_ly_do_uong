package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.dto.OrderDto;
import com.nhom2.project_capybra_system.entity.Order;
import com.nhom2.project_capybra_system.repository.IOrderRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {

    private static final String FIND_ALL_BY_NAME_AND_STATUS_ID =
            "select u.*, o.id as order_id, o.order_date, o.order_status_id from users u " +
                    " inner join orders o on u.id = o.user_id where u.name like ? and o.order_status_id like ? " +
                    "order by o.order_date desc;";
    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<OrderDto> findAllByNameAndStatusId(String name, int statusId) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_NAME_AND_STATUS_ID)) {

            statement.setString(1, "%" + name + "%");
            statement.setString(2, "%" + (statusId == 0 ? "" : statusId) + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                OrderDto orderDto = new OrderDto();

                orderDto.setName(resultSet.getString("name"));
                orderDto.setUserId(resultSet.getInt("id"));
                orderDto.setOrderDate(resultSet.getDate("order_date"));
                orderDto.setAddress(resultSet.getString("address"));
                orderDto.setOrderId(resultSet.getInt("order_id"));
                orderDto.setEmail(resultSet.getString("email"));
                orderDto.setOrderStatusId(resultSet.getInt("order_status_id"));
                orderDto.setAccountId(resultSet.getInt("account_id"));

                orderDtoList.add(orderDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDtoList;
    }
}

package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.dto.OrderDto;
import com.nhom2.project_capybra_system.dto.OrderSummaryDto;
import com.nhom2.project_capybra_system.entity.Order;
import com.nhom2.project_capybra_system.repository.IOrderRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRepository implements IOrderRepository {

    private static final String FIND_ALL_BY_NAME_AND_STATUS_ID =
            "select u.*, o.id as order_id, o.order_date, o.order_status_id from users u " +
                    " inner join orders o on u.id = o.user_id where u.name like ? and o.order_status_id like ? " +
                    "order by o.order_date desc;";
    private static final String INSERT_INTO_ORDERS = "INSERT INTO orders (user_id, order_date, order_status_id) VALUES (?, CURRENT_TIMESTAMP, 1);";
    private static final String INSERT_DETAIL_SQL = "INSERT INTO order_details (order_id, product_id, quantity) VALUES (?, ?, ?);";
    private static final String DELETE_CART_SQL = "DELETE FROM cart_details WHERE cart_id = ?;";
    private static final String SELECT_ORDER_HISTORY ="SELECT o.id, o.order_date, SUM(od.quantity) AS total_quantity, SUM(od.quantity * p.price) AS total_price, os.name AS order_status FROM orders o JOIN order_details od ON o.id = od.order_id JOIN products p ON od.product_id = p.id JOIN order_status os ON o.order_status_id = os.id WHERE o.user_id = ? GROUP BY o.id, o.order_date, os.name ORDER BY o.order_date DESC;\n";
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

    @Override
    public void placeOrder(int userId, String[] productIds, String[] quantities, int cartId) {
        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement orderStmt = connection.prepareStatement(INSERT_INTO_ORDERS, Statement.RETURN_GENERATED_KEYS)) {
                orderStmt.setInt(1, userId);
                orderStmt.executeUpdate();
                ResultSet resultSet = orderStmt.getGeneratedKeys();
                if (resultSet.next()) {
                    int orderId = resultSet.getInt(1);

                    try (PreparedStatement orderDetailStmt = connection.prepareStatement(INSERT_DETAIL_SQL)) {
                        for(int i=0;i< productIds.length;i++){
                            int productId = Integer.parseInt(productIds[i]);
                            int quantity = Integer.parseInt(quantities[i]);
                            orderDetailStmt.setInt(1, orderId);
                            orderDetailStmt.setInt(2, productId);
                            orderDetailStmt.setInt(3, quantity);
                            orderDetailStmt.executeUpdate();
                        }
                    }

                    try (PreparedStatement deleteCartStmt = connection.prepareStatement(DELETE_CART_SQL)) {
                        deleteCartStmt.setInt(1, cartId);
                        deleteCartStmt.executeUpdate();
                    }
                }
            }
            connection.commit();
        } catch (SQLException ex) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<OrderSummaryDto> getOrderSummariesByUserId(int userId) {
        List<OrderSummaryDto> summaries = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ORDER_HISTORY)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("id");
                Date orderDate = rs.getTimestamp("order_date");
                int totalQuantity = rs.getInt("total_quantity");
                String status = rs.getString("order_status");
                int totalPrice = rs.getInt("total_price");

                summaries.add(new OrderSummaryDto(orderId, orderDate, totalQuantity, status,totalPrice));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return summaries;
    }

}
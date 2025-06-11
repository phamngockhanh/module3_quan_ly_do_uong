package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.dto.OrderSummaryDto;
import com.nhom2.project_capybra_system.entity.Order;
import com.nhom2.project_capybra_system.repository.IOrderRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRepository implements IOrderRepository {
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


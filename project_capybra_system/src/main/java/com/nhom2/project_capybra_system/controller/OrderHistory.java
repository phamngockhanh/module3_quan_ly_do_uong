package com.nhom2.project_capybra_system.controller;

import com.nhom2.project_capybra_system.dto.OrderSummaryDto;
import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.repository.impl.OrderRepository;
import com.nhom2.project_capybra_system.service.IOrderService;
import com.nhom2.project_capybra_system.service.IUserService;
import com.nhom2.project_capybra_system.service.impl.OrderService;
import com.nhom2.project_capybra_system.service.impl.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/history-order")
public class OrderHistory extends HttpServlet {
    private static IOrderService orderService = new OrderService();
    private static IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account)  session.getAttribute("account");
        int userId = userService.getUserId(account.getId());
        List<OrderSummaryDto> summaryDtoList = orderService.getOrderSummariesByUserId(userId);
        req.setAttribute("summaryDtoList",summaryDtoList);
        req.getRequestDispatcher("view/user/order_history.jsp").forward(req,resp);
    }
}

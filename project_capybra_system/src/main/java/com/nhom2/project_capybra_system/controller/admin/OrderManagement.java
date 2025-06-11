package com.nhom2.project_capybra_system.controller.admin;

import com.nhom2.project_capybra_system.dto.OrderDto;
import com.nhom2.project_capybra_system.dto.UserDto;
import com.nhom2.project_capybra_system.service.IOrderService;
import com.nhom2.project_capybra_system.service.IOrderStatusService;
import com.nhom2.project_capybra_system.service.impl.OrderService;
import com.nhom2.project_capybra_system.service.impl.OrderStatusService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/order-management")
public class OrderManagement extends HttpServlet {
    private IOrderStatusService orderStatusService = new OrderStatusService();
    private IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String findStatus = req.getParameter("status");
        String findName = req.getParameter("name");
        if (findName == null) findName = "";
        if (findStatus == null) findStatus = "0";

        req.setAttribute("name", findName);
        req.setAttribute("status", findStatus);
        List<OrderDto> orderDtoList = orderService.findAllByNameAndStatusId(findName, Integer.parseInt(findStatus));
        req.setAttribute("orderList", orderDtoList);
        req.setAttribute("orderStatusList", orderStatusService.findAll());
        req.getRequestDispatcher("/view/admin/order-management/order-list.jsp").forward(req, resp);

    }
}

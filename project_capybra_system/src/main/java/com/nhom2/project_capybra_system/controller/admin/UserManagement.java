package com.nhom2.project_capybra_system.controller.admin;

import com.nhom2.project_capybra_system.dto.UserDto;
import com.nhom2.project_capybra_system.service.IUserService;
import com.nhom2.project_capybra_system.service.impl.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/user-management")
public class UserManagement extends HttpServlet {
    private IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDto> userDtoList = userService.findAllUserAndAccount();
        req.setAttribute("users", userDtoList);
        req.getRequestDispatcher("/view/admin/user-management/user-list.jsp").forward(req,resp);
    }
}

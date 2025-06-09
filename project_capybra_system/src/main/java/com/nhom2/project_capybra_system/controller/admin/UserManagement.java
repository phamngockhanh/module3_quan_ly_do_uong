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

        String userIdStr = req.getParameter("userId");
        if (userIdStr != null) {
            UserDto userDto = userService.findUserAndAccountByUserId(Integer.parseInt(userIdStr));
            req.setAttribute("user", userDto);

            req.getRequestDispatcher("/view/admin/user-management/user-detail.jsp").forward(req, resp);
        } else {
            List<UserDto> userDtoList = userService.findAllUserAndAccount();
            req.setAttribute("users", userDtoList);
            req.getRequestDispatcher("/view/admin/user-management/user-list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountIdStr = req.getParameter("accountId");
        if(accountIdStr != null){

        }
    }
}

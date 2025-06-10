package com.nhom2.project_capybra_system.controller;

import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.entity.Cart;
import com.nhom2.project_capybra_system.entity.User;
import com.nhom2.project_capybra_system.service.IAccountService;
import com.nhom2.project_capybra_system.service.ICartService;
import com.nhom2.project_capybra_system.service.IUserService;
import com.nhom2.project_capybra_system.service.impl.AccountService;
import com.nhom2.project_capybra_system.service.impl.CartService;
import com.nhom2.project_capybra_system.service.impl.UserService;
import com.nhom2.project_capybra_system.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterController extends HttpServlet {
    private IAccountService accountService = new AccountService();
    private IUserService userService = new UserService();
    private ICartService cartService = new CartService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/view/user/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if(accountService.findByUsername(username) != null){
            req.setAttribute("error", "account-existed");
            req.getRequestDispatcher("/view/user/register.jsp").forward(req, resp);
        }else{
            String password = req.getParameter("password");
            Account account = new Account(username, password);
            accountService.add(account);
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            String email = req.getParameter("email");

            userService.addUserWithAccount(username, name, phone, address, email);

            resp.sendRedirect("/homepage");
        }

    }
}

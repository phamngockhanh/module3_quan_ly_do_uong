package com.nhom2.project_capybra_system.controller;

import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.service.IAccountService;
import com.nhom2.project_capybra_system.service.impl.AccountService;
import com.nhom2.project_capybra_system.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/logout"})
public class LoginController extends HttpServlet {
    private IAccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        if("/logout".equals(action)){
            SessionUtil.remove(req, "account");
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Account account = accountService.checkLogin(username, password);
        if(account == null){
            req.setAttribute("username", username);
            req.setAttribute("message", "loginError");
            req.getRequestDispatcher("/view/user/user.jsp").forward(req,resp);
        }else{
            SessionUtil.set(req, "account", account);
            resp.sendRedirect("/homepage");
        }
    }
}

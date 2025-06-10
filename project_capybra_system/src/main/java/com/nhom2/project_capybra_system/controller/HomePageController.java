package com.nhom2.project_capybra_system.controller;

import com.nhom2.project_capybra_system.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet (value="/homepage")
public class HomePageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = (String) SessionUtil.get(req, "message");
        if (message != null) {
            req.setAttribute("message", message);
            SessionUtil.remove(req, "message");
        }
        req.getRequestDispatcher("/view/user/user.jsp").forward(req,resp);
    }
}

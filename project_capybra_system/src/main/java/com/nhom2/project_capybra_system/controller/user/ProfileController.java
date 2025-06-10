package com.nhom2.project_capybra_system.controller.user;

import com.nhom2.project_capybra_system.dto.UserDto;
import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.service.IUserService;
import com.nhom2.project_capybra_system.service.impl.UserService;
import com.nhom2.project_capybra_system.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/profile")
public class ProfileController extends HttpServlet {
    private IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account currentAccount = (Account) SessionUtil.get(req, "account");
        if(currentAccount != null){
            UserDto userDto = userService.findUserAndAccountByAccountId(currentAccount.getId());

            req.setAttribute("user", userDto);

            req.getRequestDispatcher("/view/common/profile.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("/");
        }

    }
}

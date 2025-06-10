package com.nhom2.project_capybra_system.controller.user;

import com.nhom2.project_capybra_system.dto.UserDto;
import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.entity.User;
import com.nhom2.project_capybra_system.service.IAccountService;
import com.nhom2.project_capybra_system.service.IUserService;
import com.nhom2.project_capybra_system.service.impl.AccountService;
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
    private IAccountService accountService = new AccountService();
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = (Account) SessionUtil.get(req, "account");
        User user = userService.findByUsername(account.getUsername());

        String newName = req.getParameter("name");
        String newPhone = req.getParameter("phone");
        String newAddress = req.getParameter("address");
        String newEmail = req.getParameter("email");

        user.setName(newName);
        user.setAddress(newAddress);
        user.setPhone(newPhone);
        user.setEmail(newEmail);

        boolean check = userService.updateUser(user);
        if(check){
            req.setAttribute("message", "update-success");
        }else{
            req.setAttribute("message", "update-error");
        }

        UserDto userDto = userService.findUserAndAccountByAccountId(account.getId());
        req.setAttribute("user", userDto);
        req.getRequestDispatcher("/view/common/profile.jsp").forward(req, resp);
    }
}

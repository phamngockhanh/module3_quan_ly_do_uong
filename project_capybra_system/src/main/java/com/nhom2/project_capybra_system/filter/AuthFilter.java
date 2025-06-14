package com.nhom2.project_capybra_system.filter;

import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.util.SessionUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*", "/history-order"})
public class AuthFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        Account account = (session != null) ? (Account) session.getAttribute("account") : null;

        if(account == null){
            SessionUtil.set(req, "message", "unauthorized");
            resp.sendRedirect("/homepage");
            return;
        }

        String uri = req.getRequestURI();
        if(uri.startsWith(req.getContextPath() + "/admin") && account.getRoleId() != 2){
//            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
            SessionUtil.set(req, "message", "access-denied");
            resp.sendRedirect("/homepage");

            return;
        }

        chain.doFilter(request, response);
    }
}

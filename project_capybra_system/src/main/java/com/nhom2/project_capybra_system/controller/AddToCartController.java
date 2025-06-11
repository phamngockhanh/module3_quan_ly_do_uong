package com.nhom2.project_capybra_system.controller;

import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.service.ICartDetailService;
import com.nhom2.project_capybra_system.service.ICartService;
import com.nhom2.project_capybra_system.service.IProductService;
import com.nhom2.project_capybra_system.service.IUserService;
import com.nhom2.project_capybra_system.service.impl.CartDetailService;
import com.nhom2.project_capybra_system.service.impl.CartService;
import com.nhom2.project_capybra_system.service.impl.ProductService;
import com.nhom2.project_capybra_system.service.impl.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/AddToCartServlet")
public class AddToCartController extends HttpServlet {
    private static ICartService cartService = new CartService();
    private static ICartDetailService cartDetailService = new CartDetailService();
    private static IUserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdStr = req.getParameter("productId");
        if (productIdStr == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Missing productId");
            return;
        }

        int productId = Integer.parseInt(productIdStr);
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account != null) {
            int userId = userService.getUserId(account.getId());
            int cartId = cartService.getCartId(userId);

            boolean exists = cartDetailService.existsCartDetail(cartId,productId);
            if(exists){
                int existingQuantity = cartDetailService.getQuantity(cartId,productId);
                cartDetailService.updateCartDetail(cartId,productId,existingQuantity+1);
            }else{
                cartDetailService.insertCartDetail(cartId,productId,1);
            }

        } else {
            // Chưa login → thêm vào session cart
            Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

            if (cart == null) {
                cart = new HashMap<>();
                session.setAttribute("cart", cart);
            }

            cart.put(productId, cart.getOrDefault(productId, 0) + 1);
            session.setAttribute("cart", cart);
        }

        req.getRequestDispatcher("/view/user/toast_success.jsp").forward(req, resp);
    }
}

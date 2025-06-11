package com.nhom2.project_capybra_system.controller;

import com.nhom2.project_capybra_system.dto.CartItem;
import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.entity.Product;
import com.nhom2.project_capybra_system.service.*;
import com.nhom2.project_capybra_system.service.impl.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="CartController" , urlPatterns="/cart")
public class CartController extends HttpServlet {
    private static IProductService productService = new ProductService();
    private static ICartService cartService = new CartService();
    private static ICartDetailService cartDetailService = new CartDetailService();
    private static IUserService userService = new UserService();
    private static IOrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            case "update":

                break;
            default:
                listCart(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            case "update":
                updateCart(req,resp);
                break;
            case "delete":
                deleteItem(req,resp);
                break;
            case "checkout":
                checkOut(req,resp);
                break;
            default:
                listCart(req,resp);
                break;
        }
    }

    private void checkOut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Account account = (session != null) ? (Account) session.getAttribute("account") : null;

        if (account == null) {
            req.setAttribute("checkoutError", "Bạn cần đăng nhập để thanh toán.");
            try {
                req.getRequestDispatcher("/view/user/cart.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            int userId = userService.getUserId(account.getId());
            String[] productIds = req.getParameterValues("productId");
            String[] quantities = req.getParameterValues("quantity");
            if (productIds == null || quantities == null || productIds.length != quantities.length) {
                req.setAttribute("checkoutError", "Dữ liệu giỏ hàng không hợp lệ.");
                req.getRequestDispatcher("/view/user/cart.jsp").forward(req, resp);
                return;
            }
            int cartId = cartService.getCartId(userId);

            orderService.placeOrder(userId, productIds, quantities, cartId);


            resp.sendRedirect("/view/user/order-success.jsp");
        }
    }

    private void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        mergeCardIfLoggedIn(req);
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        if(account!=null){
            int userId = userService.getUserId(account.getId());
            int cartId = cartService.getCartId(userId);
            int productId = Integer.parseInt(req.getParameter("productId"));
            cartDetailService.deleteCartDetail(cartId, productId);
        }else{
            Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

            if (cart != null) {
                int productId = Integer.parseInt(req.getParameter("productId"));
                cart.remove(productId);
                session.setAttribute("cart", cart);
            }

        }

        resp.sendRedirect("/cart");

    }


    private void updateCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        mergeCardIfLoggedIn(req);
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");

        int productId = Integer.parseInt(req.getParameter("productId"));
        String updateAction = req.getParameter("updateAction");

        if (account != null) {
            // User đã login → update DB
            int userId = userService.getUserId(account.getId());
            int cartId = cartService.getCartId(userId);

            int currentQuantity = cartDetailService.getQuantity(cartId, productId);

            if ("increase".equals(updateAction)) {
                currentQuantity++;
                cartDetailService.updateCartDetail(cartId, productId, currentQuantity);
            } else if ("decrease".equals(updateAction)) {
                if (currentQuantity > 1) {
                    currentQuantity--;
                    cartDetailService.updateCartDetail(cartId, productId, currentQuantity);
                } else {
                    cartDetailService.deleteCartDetail(cartId, productId);
                }
            }

        } else {
            Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

            if (cart == null) {
                cart = new HashMap<>();
            }

            int quantity = cart.getOrDefault(productId, 0);

            if ("increase".equals(updateAction)) {
                quantity++;
            } else if ("decrease".equals(updateAction)) {
                if (quantity > 1) {
                    quantity--;
                } else {
                    cart.remove(productId);
                }
            }

            if (quantity > 0) {
                cart.put(productId, quantity);
            }

            session.setAttribute("cart", cart);
        }

        resp.sendRedirect("/cart");
    }


    private void listCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mergeCardIfLoggedIn(req);
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        List<CartItem> cartItems = new ArrayList<>();
        if (account != null) {
            int userId = userService.getUserId(account.getId());
            Map<Integer, Integer> userCart = cartService.getUserCart(userId); // key: productId, value: quantity

            for (Map.Entry<Integer, Integer> entry : userCart.entrySet()) {
                Product product = productService.findById(entry.getKey());
                if (product != null) {
                    cartItems.add(new CartItem(product, entry.getValue()));
                }
            }

        } else {
            // Chưa login → lấy cart từ session
            Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

            if (cart != null) {
                for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                    Product product = productService.findById(entry.getKey());
                    if (product != null) {
                        cartItems.add(new CartItem(product, entry.getValue()));
                    }
                }
            }
        }

        req.setAttribute("cartItems", cartItems);
        req.getRequestDispatcher("view/user/cart.jsp").forward(req, resp);
    }

    private void mergeCardIfLoggedIn(HttpServletRequest req){
        HttpSession session = req.getSession();
        Account account = (Account)  session.getAttribute("account");

        if(account != null) {
            Map<Integer, Integer> tempCart = (Map<Integer, Integer>) session.getAttribute("cart");

            if (tempCart != null && !tempCart.isEmpty()) {
                int userId = userService.getUserId(account.getId());
                int cartId = cartService.getCartId(userId);
                 Map<Integer, Integer> userCart = cartService.getUserCart(userId);

                for (Map.Entry<Integer, Integer> entry : tempCart.entrySet()) {
                    int productId = entry.getKey();
                    int tempQuantity = entry.getValue();

                    int existingQuantity = userCart.getOrDefault(productId,0);
                    int newQuantity = existingQuantity + tempQuantity;
                    if(existingQuantity > 0){
                        cartDetailService.updateCartDetail(cartId,productId,newQuantity);
                    }else{
                        cartDetailService.insertCartDetail(cartId,productId,tempQuantity);
                    }
                }

                session.removeAttribute("cart");
            }
        }
    }
}

package com.nhom2.project_capybra_system.controller;

import com.nhom2.project_capybra_system.dto.CartItem;
import com.nhom2.project_capybra_system.entity.Account;
import com.nhom2.project_capybra_system.entity.Product;
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
            default:
                listCart(req,resp);
                break;
        }
    }

    private void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        mergeCardIfLoggedIn(req);
        HttpSession session = req.getSession();
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart != null) {
            int productId = Integer.parseInt(req.getParameter("productId"));
            cart.remove(productId);
            session.setAttribute("cart", cart);
        }

        resp.sendRedirect("/cart");

    }

    private void updateCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        mergeCardIfLoggedIn(req);
        HttpSession session = req.getSession();
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        int productId = Integer.parseInt(req.getParameter("productId"));
        String updateAction = req.getParameter("updateAction");

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
        resp.sendRedirect("/cart");
    }


//    private void updateCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        mergeCardIfLoggedIn(req);
//        HttpSession session = req.getSession();
//        Account account = (Account) session.getAttribute("account");
//
//        int productId = Integer.parseInt(req.getParameter("productId"));
//        String updateAction = req.getParameter("updateAction");
//
//        if (account != null) {
//            // User đã login → update DB
//            int userId = userService.getUserId(account.getId());
//            int cartId = cartService.getCartId(userId);
//
//            int currentQuantity = cartService.getProductQuantityInCart(cartId, productId);
//
//            if ("increase".equals(updateAction)) {
//                currentQuantity++;
//                cartDetailService.updateCartDetail(cartId, productId, currentQuantity);
//            } else if ("decrease".equals(updateAction)) {
//                if (currentQuantity > 1) {
//                    currentQuantity--;
//                    cartDetailService.updateCartDetail(cartId, productId, currentQuantity);
//                } else {
//                    cartDetailService.deleteCartDetail(cartId, productId);
//                }
//            }
//
//        } else {
//            // User chưa login → update session cart như cũ
//            Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
//
//            if (cart == null) {
//                cart = new HashMap<>();
//            }
//
//            int quantity = cart.getOrDefault(productId, 0);
//
//            if ("increase".equals(updateAction)) {
//                quantity++;
//            } else if ("decrease".equals(updateAction)) {
//                if (quantity > 1) {
//                    quantity--;
//                } else {
//                    cart.remove(productId);
//                }
//            }
//
//            if (quantity > 0) {
//                cart.put(productId, quantity);
//            }
//
//            session.setAttribute("cart", cart);
//        }
//
//        resp.sendRedirect("/cart");
//    }


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

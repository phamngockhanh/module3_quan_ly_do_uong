package com.nhom2.project_capybra_system.controller;

import com.nhom2.project_capybra_system.dto.CartItem;
import com.nhom2.project_capybra_system.entity.Product;
import com.nhom2.project_capybra_system.service.IProductService;
import com.nhom2.project_capybra_system.service.impl.ProductService;
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

    private void listCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        List<CartItem> cartItems = new ArrayList<>();
        if (cart != null) {
            for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                Product product = productService.findById(entry.getKey());
                if (product != null) {
                    cartItems.add(new CartItem(product, entry.getValue()));
                }
            }
        }

        req.setAttribute("cartItems", cartItems);
        req.getRequestDispatcher("view/user/cart.jsp").forward(req, resp);
    }
}

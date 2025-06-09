package com.nhom2.project_capybra_system.controller;

import com.nhom2.project_capybra_system.entity.Product;
import com.nhom2.project_capybra_system.service.IProductService;
import com.nhom2.project_capybra_system.service.impl.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/product")
public class ProductManagementController extends HttpServlet {
    private IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("products", products);

        req.getRequestDispatcher("/view/admin/product.jsp").forward(req, resp);
    }
}

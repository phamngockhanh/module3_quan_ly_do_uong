package com.nhom2.project_capybra_system.controller;

import com.nhom2.project_capybra_system.entity.Category;
import com.nhom2.project_capybra_system.entity.Product;
import com.nhom2.project_capybra_system.service.impl.CategoryService;
import com.nhom2.project_capybra_system.service.impl.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ProductController" , urlPatterns="/product")
public class ProductController extends HttpServlet {
    private static ProductService productService =new ProductService();
    private static CategoryService categoryService =new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case "detail":
                productDetail(req,resp);
                break;
            default:
                listProduct(req,resp);
                break;
        }
    }

    private void productDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = productService.findById(Integer.parseInt(id));
        List<Category> categories  = categoryService.findAll();
        req.setAttribute("product",product);
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("view/user/product_detail.jsp").forward(req,resp);
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("products",products);
        req.getRequestDispatcher("view/user/product.jsp").forward(req,resp);
    }

}

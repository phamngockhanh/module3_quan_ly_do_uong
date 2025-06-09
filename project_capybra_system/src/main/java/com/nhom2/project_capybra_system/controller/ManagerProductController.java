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

import static java.nio.file.Files.delete;

@WebServlet(value = "/managerProduct")
public class ManagerProductController extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(req,resp);
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                List<Product> productList= productService.findAll();
                req.setAttribute("productList", productList);
                req.getRequestDispatcher("/view/admin/managerProduct.jsp").forward(req, resp);
        }


    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   req.getRequestDispatcher("/view/admin/addProduct.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addProduct(req,resp);
                break;
            case "update":
                break;
            case "delete":
                delete(req,resp);
                break;

        }
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name=req.getParameter("name");
        long price= Long.parseLong(req.getParameter("price"));
        int categoryId= Integer.parseInt(req.getParameter("categoryId"));
        boolean status= Boolean.parseBoolean(req.getParameter("status"));
        String description=req.getParameter("description");
        String image=req.getParameter("image");
        Product product= new Product(name,price,categoryId,status,description,image);
        req.setAttribute("product",product);
        resp.sendRedirect("/managerProduct?mess=add success");


    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteId= Integer.parseInt(req.getParameter("deleteId"));
        productService.delete(deleteId);
        resp.sendRedirect("managerProduct?mess=delete success");
    }

}
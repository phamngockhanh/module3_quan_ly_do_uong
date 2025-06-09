package com.nhom2.project_capybra_system.controller;

import com.nhom2.project_capybra_system.entity.Category;
import com.nhom2.project_capybra_system.entity.Product;
import com.nhom2.project_capybra_system.service.ICategoryService;
import com.nhom2.project_capybra_system.service.IProductService;
import com.nhom2.project_capybra_system.service.impl.CategoryService;
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
    private ICategoryService iCategoryService = new CategoryService();
    private List<Category> categories = iCategoryService.findAll();
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "delete":
                break;
            default:
                List<Product> productList = productService.findAll();
                req.setAttribute("productList", productList);
                req.setAttribute("category", categories);
                req.getRequestDispatcher("/view/admin/managerProduct.jsp").forward(req, resp);
        }


    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/view/admin/updateProduct.jsp").forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/admin/addProduct.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addProduct(req, resp);
                break;
            case "update":
                updateProduct(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;

        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        long price = Long.parseLong(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        Product product = new Product(id,name, price, categoryId, status);
        productService.update(product);
        resp.sendRedirect("/managerProduct?mess=update success");
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        long price = Long.parseLong(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        String description = req.getParameter("description");
        String image = req.getParameter("image");
        String size = req.getParameter("size");
        Product product = new Product(name, price, categoryId, status, description, image, size);
        productService.add(product);
        resp.sendRedirect("/managerProduct?mess=add success");


    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        productService.delete(deleteId);
        resp.sendRedirect("managerProduct?mess=delete success");
    }

}
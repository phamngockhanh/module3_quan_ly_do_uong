package com.nhom2.project_capybra_system.controller.admin;

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

@WebServlet(urlPatterns = "/admin/product-management")
public class ProductManagement extends HttpServlet {
    private ICategoryService iCategoryService = new CategoryService();
    private List<Category> categories = iCategoryService.findAll();
    private IProductService productService = new ProductService();

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
            case "search":
                search(req, resp);
                break;
            case "addCategory":
                addCategory(req,resp);
            default:
                List<Product> productList = productService.findAll();
                req.setAttribute("productList", productList);
                req.setAttribute("categories", categories);
                req.getRequestDispatcher("/view/admin/product-management/product-list.jsp").forward(req, resp);
        }


    }

    private void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/admin/addCategory.jsp").forward(req, resp);

    }



    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String categoryIdParam = req.getParameter("categoryId");

        Integer categoryId = null;
        if (categoryIdParam != null && !categoryIdParam.trim().isEmpty()) {
            try {
                categoryId = Integer.parseInt(categoryIdParam);
            } catch (NumberFormatException e) {
                categoryId = null; // hoặc log lỗi
            }
        }
        List<Product> productList = productService.search(name, categoryId);
        List<Category> categories = iCategoryService.findAll();
        req.setAttribute("productList", productList);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/view/admin/product-management/product-list.jsp").forward(req, resp);    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("categories", categories);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/view/admin/product-management/product-form.jsp").forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/view/admin/product-management/product-form.jsp").forward(req, resp);
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
            case "addCategory":
                saveCategory(req,resp);

        }
    }

    private void saveCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name= req.getParameter("name");
        Category category = new Category(name);
        categories.add(category);
        resp.sendRedirect("/admin/product-management?mess=add success");

    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        long price = Long.parseLong(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        String image=req.getParameter("image");
        Product product = new Product(id,name, price, categoryId, status,image);
        productService.update(product);
        resp.sendRedirect("/admin/product-management?mess=update success");
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
        resp.sendRedirect("/admin/product-management?mess=add success");


    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        productService.delete(deleteId);
        resp.sendRedirect("/admin/product-management?mess=delete success");
    }
}

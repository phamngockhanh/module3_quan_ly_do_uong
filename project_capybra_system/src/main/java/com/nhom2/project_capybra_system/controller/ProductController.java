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
            case "cart":
                addToCart(req,resp);
                break;
            default:
                listProduct(req,resp);
                break;
        }
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) {

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
        int pageNumber = 1;
        int pageSize = 9;
        String pageParam = req.getParameter("pageNumber");
        String categoryParam = req.getParameter("categoryId");
        String keyword =req.getParameter("keyword") != null? req.getParameter("keyword").trim() : "";
        int categoryId = 0;
        if(categoryParam != null && !categoryParam.isEmpty()){
            try{
                categoryId = Integer.parseInt(categoryParam);
            }catch (NumberFormatException ex){
                categoryId = 0;
            }
        }
        int totalProducts;
        if (categoryId == 0 && keyword.isEmpty()) {
            totalProducts = productService.countProduct();
        } else {
            totalProducts = productService.countProductWithFilter(keyword, categoryId);
        }

        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        if (totalPages == 0) {
            totalPages = 1;
        }
        if (pageParam != null) {
            try {
                pageNumber = Integer.parseInt(pageParam);
                if (pageNumber > totalPages) {
                    pageNumber = 1;
                }
            } catch (NumberFormatException e) {
                pageNumber = 1;
            }
        }

        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);

        int offset = (pageNumber - 1) * pageSize;
        List<Product> products;
        if (categoryId == 0 && keyword.isEmpty()) {
            products = productService.findAllNoneFilter(offset, pageSize);
        } else {
            products = productService.findAllWithPagination(keyword, categoryId, offset, pageSize);
        }

        req.setAttribute("products", products);
        req.setAttribute("currentPage", pageNumber);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("selectedCategoryId", categoryId);
        req.setAttribute("keyword", keyword);

        req.getRequestDispatcher("view/user/product.jsp").forward(req,resp);
    }

}

package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.ProductService;
import com.j256.ormlite.stmt.query.In;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BusinessIndexServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));//id为商家id
        String action = request.getParameter("action");

        if(action == "add"){
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            String type = request.getParameter("type");
            String description = request.getParameter("description");
            ProductService productService = new ProductService();
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);
            product.setDescription(description);
            product.setSId(id);
            productService.addProduct(product);
            request.getRequestDispatcher("businessIndex.jsp").forward(request, response);
        }
    }
}

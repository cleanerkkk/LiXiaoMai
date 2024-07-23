package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/businessManage")
public class BusinessManageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        String name = (String) session.getAttribute("name");

        BusinessService businessService = new BusinessService();
        ProductService productService = new ProductService();

        List<Product> productList = productService.getAllProductBySid(id);
        request.setAttribute("productList", productList);







    }
}

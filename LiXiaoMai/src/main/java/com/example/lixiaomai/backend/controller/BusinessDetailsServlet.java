package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.entity.Comment;
import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.CommentService;
import com.example.lixiaomai.backend.service.OrderService;
import com.example.lixiaomai.backend.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BusinessDetailsServlet")
public class BusinessDetailsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));//id为商家id

        BusinessService businessService=new BusinessService();
        Business business=businessService.getAllInfoOfBusiness(id);
        ProductService productService=new ProductService();
        List<Product> productForShop=productService.getAllProductBySid(id);

        request.setAttribute("business",business);
        request.setAttribute("id",id);
        request.setAttribute("productForShop",productForShop);
        request.getRequestDispatcher("businessDetails.jsp").forward(request, response);
    }
}

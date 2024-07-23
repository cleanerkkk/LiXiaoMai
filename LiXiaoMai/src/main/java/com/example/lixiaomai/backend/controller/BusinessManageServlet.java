package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/businessManage")
public class BusinessManageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        String name = (String) session.getAttribute("name");

        BusinessService businessService = new BusinessService();
        Business business=businessService.getBusinessById(id);
        String shopName=business.getShopName();
        ProductService productService = new ProductService();

        List<Product> productList = productService.getAllProductBySid(id);
        request.setAttribute("productList", productList);
        request.setAttribute("business",business);
        request.setAttribute("id",id);
        request.setAttribute("shopName",shopName);
        request.getRequestDispatcher("businessManage.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        String name = (String) session.getAttribute("name");

        BusinessService businessService = new BusinessService();
        ProductService productService = new ProductService();

        String action = request.getParameter("action");
        String productName = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String type = request.getParameter("type");
        String url = request.getParameter("image");
        Integer productId = Integer.parseInt(request.getParameter("productId"));

        Product product = new Product();
        product.setName(productName);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        product.setSId(id);
        product.setPitcutreUrl(url);
        product.setType(type);


        if (action.equals("add") ) {
            productService.addProduct(product);
            response.sendRedirect("businessManage.jsp");
        } else if (action.equals("update") ){
            product.setId(productId);
            productService.updateProduct(product);
        } else if (action.equals("delete")) {
            productService.deleteProductById(productId);
        }
        response.sendRedirect(request.getContextPath() + "/sameServlet");

    }
}

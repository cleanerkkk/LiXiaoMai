package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Cart;
import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.service.CartService;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        Integer id = (Integer) session.getAttribute("id");

        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getUserById(id);

        CartService cartService = new CartService();
        Cart cart = cartService.getCartByCid(id);
        ProductService productService = new ProductService();
        List<Product> list = new ArrayList<>();
        for (int gid : cart.getGId()){
            Product product = productService.getProductById(gid);
            list.add(product);
        }
        request.setAttribute("name", customer.getName());
        request.setAttribute("product", list);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request,response);



    }
}

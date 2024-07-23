package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.entity.Cart;
import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.CartService;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.ProductService;
import org.apache.commons.lang3.tuple.Pair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        Integer id = (Integer) session.getAttribute("id");

        CustomerService customerService = new CustomerService();
        BusinessService businessService = new BusinessService();
        CartService cartService = new CartService();

        Customer customer = customerService.getUserById(id);
        Cart cart = cartService.getCartByCid(id);


        Map<Integer, List<Pair<Integer,Integer>>> map = cartService.diffProducts(cart);
        Map<Integer, String> sNameMap = new HashMap<>();

        for (Map.Entry<Integer, List<Pair<Integer,Integer>>> entry : map.entrySet()) {
            int sId = entry.getKey();
            ProductService productService = new ProductService();
            sNameMap.put(sId, productService.getShopNameBySid(sId));
        }

        request.setAttribute("name", customer.getName());

        request.setAttribute("productMap", map);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request,response);
    }
}

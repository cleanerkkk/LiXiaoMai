package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.*;
import com.example.lixiaomai.backend.service.*;
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
        WalletService walletService = new WalletService();
        CartService cartService = new CartService();
        CouponService couponService = new CouponService();

        Customer customer = customerService.getUserById(id);
        Cart cart = cartService.getCartByCid(id);
        Wallet wallet = walletService.getWalletById(id);


        Map<Integer, List<Pair<Product,Integer>>> map = cartService.diffProducts(cart);
        Map<Integer, String> sNameMap = new HashMap<>();

        for (Map.Entry<Integer, List<Pair<Product,Integer>>> entry : map.entrySet()) {
            int sId = entry.getKey();
            sNameMap.put(sId, businessService.getBusinessById(sId).getName());
        }

        List<Integer> discountIds = wallet.getDId();
        List<Coupon> couponList = couponService.getAllCouponsByIdList(discountIds);


        request.setAttribute("couponList", couponList);
        request.setAttribute("name", customer.getName());
        request.setAttribute("sNameMap", sNameMap);
        request.setAttribute("productMap", map);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request,response);
    }
}

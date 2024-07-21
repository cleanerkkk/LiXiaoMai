package com.example.lixiaomai.backend.controller;


import com.example.lixiaomai.backend.entity.Coupon;
import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Wallet;
import com.example.lixiaomai.backend.service.CouponService;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.WalletService;

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

@WebServlet("/ProfileCoupon")
public class ProfileCouponServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String userType = (String) session.getAttribute("userType");
        String username = (String) session.getAttribute("name");


        if (userType.equals("customer")) {

            CustomerService customerService = new CustomerService();
            CouponService couponService = new CouponService();

            Customer customer = customerService.getUserByUsername(username);

            int id = customer.getId();
            WalletService walletService = new WalletService();
            Wallet wallet = walletService.getWalletById(id);

            Map<Coupon, Integer> couponMap = new HashMap<>();
            for (int i = 0; i < wallet.getDId().size(); i++) {
                int wid = wallet.getDId().get(i);
                Coupon coupon = couponService.getCouponById(wid);
                int cnt = wallet.getDiscountNum().get(i);
                couponMap.put(coupon, cnt);

            }
            session.setAttribute("couponMap", couponMap);
            response.sendRedirect("profileCoupon.jsp");

        } else {
            String errorMessage = "You are not a customer!";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("profile.jsp?error=" + errorMessage).forward(request, response);
        }




    }
}

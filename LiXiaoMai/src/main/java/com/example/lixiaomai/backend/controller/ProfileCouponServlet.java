package com.example.lixiaomai.backend.controller;


import com.example.lixiaomai.backend.entity.Coupon;
import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Wallet;
import com.example.lixiaomai.backend.service.CouponService;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.WalletService;
import jdk.internal.net.http.common.Pair;

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

            List<Pair<Coupon,Integer>> list = new ArrayList<>();
            for (int i = 0; i < wallet.getDId().size(); i++) {
                int wid = wallet.getDId().get(i);
                Coupon coupon = couponService.getCouponById(wid);
                int cnt = wallet.getDiscountNum().get(i);
                list.add(new Pair<>(coupon,cnt));

            }

            int page = 1;
            int recordsPerPage = 2;
            String x = request.getParameter("page");

            if (x != null) {
                try {
                    page = Integer.parseInt(request.getParameter("page"));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            int allRecords = list.size();
            int totalPages = (int) Math.ceil(allRecords * 1.0 / recordsPerPage);
            int start = (page - 1) * recordsPerPage;
            int end = Math.min(start + recordsPerPage, allRecords);
            List<Pair<Coupon,Integer>> paginatedList = list.subList(start, end);
            request.setAttribute("couponList", paginatedList);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("currentPage", page);


            request.getRequestDispatcher("profileCoupon.jsp").forward(request, response);

        } else {
            String errorMessage = "You are not a customer!";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("profile.jsp?error=" + errorMessage).forward(request, response);
        }







    }
}

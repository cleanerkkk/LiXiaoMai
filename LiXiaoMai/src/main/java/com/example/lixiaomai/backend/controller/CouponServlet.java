package com.example.lixiaomai.backend.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import com.example.lixiaomai.backend.entity.Coupon;
import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Wallet;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.WalletService;
import lombok.SneakyThrows;
import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.System.out;

@WebServlet(urlPatterns = "/coupon")
public class CouponServlet extends HttpServlet {
    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        StringBuilder jsonStringBuilder = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
        }

        String jsonString = jsonStringBuilder.toString();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        String result = null;
        try {
            result = jsonObject.getString("result");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        Coupon coupon = new Coupon();
        if (result.equals("一等奖")){
            coupon.setDiscount(15);
            coupon.setLimit(20);
            coupon.setId(10086);
        }
        else if (result.equals("二等奖")){
            coupon.setDiscount(10);
            coupon.setLimit(15);
            coupon.setId(10087);

        }
        else if (result.equals("三等奖")){
            coupon.setDiscount(5);
            coupon.setLimit(10);
            coupon.setId(10088);
        }
        else if (result.equals("特等奖")){
            coupon.setId(666);
            coupon.setDiscount(20);
            coupon.setLimit(0);
        }

        String username = (String) request.getSession().getAttribute("name");
        CustomerService customerService = new CustomerService();
        int id = customerService.getUserByUsername(username).getId();
        WalletService walletService = new WalletService();
        if (!result.equals("谢谢参与"))
            walletService.addCouponById(id, coupon);

    }
}

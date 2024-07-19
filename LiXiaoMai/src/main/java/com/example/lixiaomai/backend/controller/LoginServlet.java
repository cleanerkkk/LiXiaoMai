package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.service.CustomerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String user = request.getParameter("user");
        String captcha = request.getParameter("captcha");

        String generCaptcha = (String) request.getSession().getAttribute("captchaValue");

        if (!captcha.equalsIgnoreCase(generCaptcha)){
            String errorMessage = "验证码错误";
            // 登录失败
        }

        if (user.equals("customer")) {
            CustomerService customerService = new CustomerService();
            boolean loginResult = customerService.login(username, password);

        } else if (user.equals("admin")){

        } else if (user.equals("deliverman")) {

        } else {

        }

    }

}

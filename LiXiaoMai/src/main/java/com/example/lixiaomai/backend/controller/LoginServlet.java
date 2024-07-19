package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.service.AdminService;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.DelivermanService;

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
        String errorMessage;

        String generCaptcha = (String) request.getSession().getAttribute("captchaValue");

        if (!captcha.equalsIgnoreCase(generCaptcha)){
             errorMessage = "验证码错误";
            // 登录失败
        }
        boolean loginResult;
        switch (user) {
            case "customer":
                CustomerService customerService = new CustomerService();
                loginResult = customerService.login(username, password);

                break;
            case "admin":
                AdminService adminService = new AdminService();
                loginResult = adminService.login(username, password);

                break;
            case "deliverman":
                DelivermanService delivermanService = new DelivermanService();
                loginResult = delivermanService.login(username, password);
                break;
            default:
                BusinessService businessService = new BusinessService();
                loginResult = businessService.login(username, password);
                break;
        }

        if (loginResult){
            request.getSession().setAttribute("name", username);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("userinfo.jsp");
        }
        else{
            errorMessage = "用户名或密码错误";
        }


    }

}

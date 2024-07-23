package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.entity.Wallet;
import com.example.lixiaomai.backend.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");



        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userType = request.getParameter("user");
        String captcha = request.getParameter("captcha");
        String errorMessage;

        String generCaptcha = (String) request.getSession().getAttribute("captchaValue");
        request.getSession().invalidate();
        if (!captcha.equalsIgnoreCase(generCaptcha) && false){
            errorMessage = "验证码错误";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("login.jsp?error=" + errorMessage).forward(request, response);
            return ;
        }
        boolean loginResult;
        Integer id = null;
        switch (userType) {
            case "customer":
                CustomerService customerService = new CustomerService();
                loginResult = customerService.login(username, password);
                id = customerService.getUserByUsername(username).getId();
                WalletService walletService = new WalletService();
                Wallet wallet = walletService.getWalletById(customerService.getUserByUsername(username).getId());

                int cnt = 0;
                for (int i = 0; i < wallet.getDiscountNum().size(); i++) {
                    cnt += wallet.getDiscountNum().get(i);
                }
                boolean ableToTurn = cnt >= 5;
                request.setAttribute("ableToTurn", ableToTurn);

                break;
            case "admin":
                AdminService adminService = new AdminService();
                loginResult = adminService.login(username, password);
                break;
            case "deliverman":
                DelivermanService delivermanService = new DelivermanService();
                loginResult = delivermanService.login(username, password);
                id = delivermanService.getDelivermanByUsername(username).getId();
                break;
            default:
                BusinessService businessService = new BusinessService();
                id = businessService.getBusinessByUsername(username).getId();
                loginResult = businessService.login(username, password);
                break;
        }

        if (loginResult){
            request.getSession().setAttribute("name", username);
            request.getSession().setAttribute("userType", userType);
            request.getSession().setAttribute("id", id);

            response.sendRedirect("exhibit");
        }
        else{
            errorMessage = "用户名或密码错误";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("login.jsp?error=" + errorMessage).forward(request, response);
        }


    }

}

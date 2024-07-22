package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Deliverman;
import com.example.lixiaomai.backend.entity.Wallet;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.DelivermanService;
import com.example.lixiaomai.backend.service.WalletService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.function.Consumer;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String registerType = request.getParameter("registerUser");
        String registerUserName = request.getParameter("registerUsername");
        String firstPassword = request.getParameter("firstPassword");
        String trueName = request.getParameter("trueName");
        String gender = request.getParameter("gender");
        String telephone = request.getParameter("telephone");
        String idCard = request.getParameter("idCard");
        String storeName = request.getParameter("storeName");
        String address = request.getParameter("address");
        Date date= Date.valueOf(request.getParameter("date"));

        boolean flag = false;

        if (registerType.equals("customer")) {



            CustomerService customerService = new CustomerService();

            if (customerService.existCustomer(registerUserName)){
                response.sendRedirect("login.jsp?error=" + "用户名已存在");
                return;
            }

            Customer customer = new Customer();
            Wallet wallet = new Wallet();

            customer.setName(trueName);
            customer.setPassword(firstPassword);
            customer.setUName(registerUserName);
            customer.setGender(gender);
            customer.setTelephone(telephone);
            customer.setAddress(address);
            customer.setBirthday(date);

            wallet.setPassword(firstPassword);

            WalletService walletService = new WalletService();
            walletService.addWallet(wallet);
            flag = customerService.addCustomer(customer);

        }
        else if (registerType.equals("business")) {
            BusinessService businessService = new BusinessService();

            if (businessService.existBusiness(registerUserName)){
                response.sendRedirect("login.jsp?error=" + "用户名已存在");
                return;
            }

            Business business = new Business();
            business.setUName(registerUserName);
            business.setPassword(firstPassword);
            business.setShopName(storeName);
            business.setAddress(address);
            business.setTelephone(telephone);
            business.setIdCard(idCard);
            business.setName(trueName);

            flag = businessService.addBusiness(business);

        }
        else{
            String vType = request.getParameter("vType");
            String vBrand = request.getParameter("vBrand");

            DelivermanService delivermanService = new DelivermanService();

            if (delivermanService.existDeliverman(registerUserName)){
                response.sendRedirect("login.jsp?error=" + "用户名已存在");
                return;
            }

            Deliverman deliverman = new Deliverman();

            deliverman.setUName(registerUserName);
            deliverman.setPassword(firstPassword);
            deliverman.setName(trueName);
            deliverman.setGender(gender);
            deliverman.setTelephone(telephone);
            deliverman.setVBrand(vBrand);
            deliverman.setVType(vType);

            flag = delivermanService.addDeliverman(deliverman);

        }

        if (flag){
            response.sendRedirect("login.jsp?error=" + "注册成功");
        }
        else
            response.sendRedirect("login.jsp?error=" + "注册失败");





    }
}

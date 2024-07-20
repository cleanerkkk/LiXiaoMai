package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.service.CustomerService;
import com.mysql.cj.Session;
import com.sun.net.httpserver.HttpsServer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ProfileOrder")
public class ProfileOrderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String userType = (String) session.getAttribute("userType");
        String userName = (String) session.getAttribute("name");

        if (userType.equals("customer")){
            CustomerService customerService = new CustomerService();

        }
        else if (userType.equals("business")){

        }
        else if (userType.equals("deliverman")){

        }
        else {

        }

    }
}

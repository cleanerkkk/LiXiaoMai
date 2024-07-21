package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.DelivermanService;
import com.example.lixiaomai.backend.service.OrderService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/ProfileSettings")
public class ProfileSettingsServlet  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String userType = (String) session.getAttribute("userType");
        String name = (String) session.getAttribute("name");

        session.setAttribute(userType,"userType");
        session.setAttribute(name,"name");
        response.sendRedirect("profileSettings.jsp");
        //12346



    }
}

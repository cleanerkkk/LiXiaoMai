package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.DelivermanService;
import com.example.lixiaomai.backend.service.OrderService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/ProfileSettingsServlet")
public class ProfileSettingsServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String userType = (String) session.getAttribute("userType");
        String userName = (String) session.getAttribute("name");
        OrderService orderService = new OrderService();

        if (userType.equals("customer")){
            CustomerService customerService = new CustomerService();
            List<Order> list = orderService.getAllOrderByCid(customerService.getUserByUsername(userName).getId());
            session.setAttribute("orderList",list);
        }
        else if (userType.equals("business")){
            BusinessService businessService = new BusinessService();
            List<Order> list = orderService.getAllOrderBySid(businessService.getBusinessByUsername(userName).getId());
            session.setAttribute("orderList",list);
        }
        else if (userType.equals("deliverman")){
            DelivermanService delivermanService = new DelivermanService();
            List<Order> list = orderService.getAllOrderByDId(delivermanService.getDelivermanByUsername(userName).getId());
            session.setAttribute("orderList",list);
        }
        response.sendRedirect("profileOrder.jsp");
        //12346



    }
}

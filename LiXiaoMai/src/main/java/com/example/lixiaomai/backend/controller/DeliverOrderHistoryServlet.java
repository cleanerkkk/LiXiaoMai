package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Deliverman;
import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.service.DelivermanService;
import com.example.lixiaomai.backend.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/deliverOrderHistory")
public class DeliverOrderHistoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");
        String userName = (String) session.getAttribute("name");
        OrderService orderService=new OrderService();
        DelivermanService delivermanService=new DelivermanService();
        Deliverman deliverman =delivermanService.getDelivermanByUsername(userName);
        int delivermanId=deliverman.getId();
        List<Order> orderList=orderService.getAllOrderByDId(delivermanId);
        request.setAttribute("orderList",orderList);
        request.setAttribute("delivermanId",delivermanId);
        request.setAttribute("deliverman",deliverman);
        request.getRequestDispatcher("delivermanOrderHistory.jsp").forward(request,response);
    }
}

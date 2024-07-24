package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderGet")
public class DeliverOrderGetServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.getAllOrderWithNoDeliver();

        request.setAttribute("orderList", orderList);
        request.getRequestDispatcher("delivermanOrderGet.jsp").forward(request, response);
    }
}

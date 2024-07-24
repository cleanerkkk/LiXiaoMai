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

@WebServlet("/deliverAdd")
public class DeliverOrderAddServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");
        String userName = (String) session.getAttribute("name");

        OrderService orderService = new OrderService();
        DelivermanService delivermanService = new DelivermanService();
        Deliverman deliverman = delivermanService.getDelivermanByUsername(userName);
        int id = deliverman.getId();

        String[] selectedOrderIds = request.getParameterValues("selectedOrders");

        if(selectedOrderIds != null){
            for(String orderIds : selectedOrderIds){
                try{
                    int orderId = Integer.parseInt(orderIds);
                    Order order = orderService.getOrderById(orderId);
                    order.setDeliverId(id);
                    order.setStatus(1);
                    orderService.updateOrder(order);
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }
        response.sendRedirect("orderGet");
    }
}

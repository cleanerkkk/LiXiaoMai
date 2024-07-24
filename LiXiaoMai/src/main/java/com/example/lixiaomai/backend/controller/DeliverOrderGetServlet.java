package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Deliverman;
import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.DelivermanService;
import com.example.lixiaomai.backend.service.OrderService;
import org.w3c.dom.ls.LSException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/orderGet")
public class DeliverOrderGetServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");
        String userName = (String) session.getAttribute("name");

        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.getAllOrderWithNoDeliver();

        DelivermanService delivermanService = new DelivermanService();
        Deliverman deliverman = delivermanService.getDelivermanByUsername(userName);

        CustomerService customerService = new CustomerService();
        List<String> addressList = new ArrayList<>();
        for(int i = 0; i < orderList.size(); ++i){
            Order order = orderList.get(i);
            Customer customer = customerService.getUserById(order.getCId());
            addressList.add(customer.getAddress());
        }
        request.setAttribute("addressList", addressList);
        request.setAttribute("orderList", orderList);
        request.setAttribute("deliverman", deliverman);
        request.getRequestDispatcher("delivermanOrderGet.jsp").forward(request, response);
    }
}

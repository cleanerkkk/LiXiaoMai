package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Comment;
import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/businessOrder")
//
public class BusinessOrderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Integer id = Integer.parseInt(request.getParameter("id"));

        OrderService orderService = new OrderService();
        ProductService productService = new ProductService();
        CommentService commentService = new CommentService();

        Order order = orderService.getOrderById(id);
        List<String> productNameList = new ArrayList<>();

        List<Integer> productIds = order.getGId();
        for (int pId : productIds) {
            String productName = productService.getProductById(pId).getName();
            productNameList.add(productName);
        }
        List<Comment> commentList = commentService.getCommentByOId(id);

        Comment commentStartWithCustomer = commentService.getCommentStartWithCustomerByOId(id);
        Comment commentEndWithDeliverman = commentService.getCommentEndWithDelivermanByOId(id);
        Comment commentStartWithBusiness = commentService.getCommentStartWithBusinessByOId(id);

        request.setAttribute("customerComment", commentStartWithCustomer);
        request.setAttribute("deliverComment", commentEndWithDeliverman);
        request.setAttribute("businessComment", commentStartWithBusiness);


        CustomerService customerService = new CustomerService();
        int customerId = order.getCId();

        String customerUName = customerService.getUserById(customerId).getUName();
        DelivermanService delivermanService = new DelivermanService();
        int deliverId = order.getDeliverId();
        String deliverName = "正在匹配骑手";
        if(deliverId != 0) delivermanService.getDelivermanById(deliverId).getName();
        request.setAttribute("customerUName", customerUName);
        request.setAttribute("deliverName", deliverName);
        request.setAttribute("commentList", commentList);
        request.setAttribute("order", order);
        request.setAttribute("productNameList", productNameList);
        request.getRequestDispatcher("businessOrderDetails.jsp").forward(request, response);
    }
}

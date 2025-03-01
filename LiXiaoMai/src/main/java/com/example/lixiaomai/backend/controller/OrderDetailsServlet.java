package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Comment;
import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.service.CommentService;
import com.example.lixiaomai.backend.service.DelivermanService;
import com.example.lixiaomai.backend.service.OrderService;
import com.example.lixiaomai.backend.service.ProductService;
import com.mysql.cj.Session;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/orderDetails")
public class OrderDetailsServlet extends HttpServlet{
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

        Comment commentEndWithBusiness = commentService.getCommentEndWithBusinessByOId(id);
        Comment commentEndWithDeliverman = commentService.getCommentEndWithDelivermanByOId(id);
        request.setAttribute("businessComment", commentEndWithBusiness);
        request.setAttribute("deliverComment", commentEndWithDeliverman);

        DelivermanService delivermanService = new DelivermanService();
        int deliverId = order.getDeliverId();
        String deliverName = "正在匹配骑手";
        if (deliverId != 0) {
            deliverName = delivermanService.getDelivermanById(deliverId).getName();
        }
        request.setAttribute("deliverName", deliverName);
        request.setAttribute("commentList", commentList);
        request.setAttribute("order", order);
        request.setAttribute("productNameList", productNameList);
        request.getRequestDispatcher("orderDetails.jsp").forward(request, response);

    }


}

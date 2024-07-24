package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Comment;
import com.example.lixiaomai.backend.service.CommentService;
import com.example.lixiaomai.backend.tools.Tool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        Integer uid = (Integer) session.getAttribute("id");
        String userName = (String) session.getAttribute("name");

        Integer oId = Integer.parseInt(request.getParameter("oId"));

        String action = request.getParameter("action");
        if(action.equals("order")){
            Integer deliverId = Integer.parseInt(request.getParameter("deliverId"));
            Integer businessId = Integer.parseInt(request.getParameter("businessId"));
            String businessComment = request.getParameter("business");
            String delivermanComment = request.getParameter("deliverman");
            String businessName = request.getParameter("businessName");
            String businessShopName = request.getParameter("businessShopName");
            String delivermanName = request.getParameter("deliverName");

            if (businessComment == null || businessComment.isEmpty()) {
                businessComment = "用户默认好评";
            }
            if (delivermanComment == null || delivermanComment.isEmpty()) {
                delivermanComment = "用户默认好评";
            }

            CommentService commentService = new CommentService();

            Comment comment = new Comment();
            comment.setOId(oId);
            comment.setStartId(uid);
            comment.setEndId(businessId);
            comment.setContent(businessComment);
            comment.setStatus(1);
            comment.setLikes(0);
            comment.setDislikes(0);
            comment.setStartName(userName);
            comment.setEndName(businessShopName);
            comment.setTime(Tool.getTime());
            comment.setCoId(0);

            commentService.addComment(comment);

            comment.setEndId(deliverId);
            comment.setContent(delivermanComment);
            comment.setEndName(delivermanName);

            commentService.addComment(comment);

            response.sendRedirect("orderDetails?id=" + oId);
        }else if(action.equals("businessOrder")){
            Integer deliverId = Integer.parseInt(request.getParameter("deliverId"));
            Integer customerId = Integer.parseInt(request.getParameter("customerId"));
            String customerComment = request.getParameter("customer");
            String delivermanComment = request.getParameter("deliverman");
            String customerUName = request.getParameter("customerUName");
            String delivermanName = request.getParameter("deliverName");
            String businessShopName = request.getParameter("businessShopName");

            if (customerComment == null || customerComment.isEmpty()) {
                customerComment = "用户默认好评";
            }

            CommentService commentService = new CommentService();

            Comment comment = new Comment();
            comment.setOId(oId);
            comment.setStartId(uid);
            comment.setEndId(customerId);
            comment.setContent(customerComment);
            comment.setStatus(1);
            comment.setLikes(0);
            comment.setDislikes(0);
            comment.setStartName(businessShopName);
            comment.setEndName(customerUName);
            comment.setTime(Tool.getTime());
            comment.setCoId(0);

            commentService.addComment(comment);


            response.sendRedirect("businessOrder?id=" + oId);
        }


    }
}

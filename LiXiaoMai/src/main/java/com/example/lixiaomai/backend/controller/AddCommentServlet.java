package com.example.lixiaomai.backend.controller;
import com.example.lixiaomai.backend.service.CommentService;
import com.example.lixiaomai.backend.entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddComment")
public class AddCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        String commentText = request.getParameter("comment");
        String user = (String) request.getSession().getAttribute("username");

        CommentService commentService = new CommentService();
        Comment comment = new Comment();
        //comment.setOrderId(Integer.parseInt(orderId));
        //comment.setText(commentText);
        //comment.setUser(user);

        commentService.addComment(comment);

        response.sendRedirect("OrderDetails?id=" + orderId);
    }
}

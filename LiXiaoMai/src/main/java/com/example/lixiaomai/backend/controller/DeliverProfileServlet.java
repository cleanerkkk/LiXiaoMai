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

@WebServlet("/deliverProfile")
public class DeliverProfileServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Deliverman deliverman= (Deliverman) session.getAttribute("deliverman");
        int id=deliverman.getId();
        request.setAttribute("id",id);
        request.setAttribute("deliverman",deliverman);
        request.getRequestDispatcher("delivermanProfile.jsp").forward(request,response);
    }
}

package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/businessProfile")
public class BusinessProfileServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Business business=(Business)session.getAttribute("business");
        int id=business.getId();

        request.setAttribute("id",id);
        request.setAttribute("business",business);
        request.getRequestDispatcher("businessProfile.jsp").forward(request,response);
    }
}

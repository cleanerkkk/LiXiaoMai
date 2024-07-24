package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.entity.Deliverman;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.DelivermanService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/profileCheck")
public class AdminProfileCheck extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        BusinessService businessService = new BusinessService();
        DelivermanService delivermanService = new DelivermanService();

        List<Business> businessList = businessService.getBusinessByStatus(0);
        List<Deliverman> delivermanList = delivermanService.getDelivermanByStatus(0);

        HttpSession session = request.getSession();

        session.setAttribute("businessList", businessList);
        session.setAttribute("delivermanList", delivermanList);

        response.sendRedirect("adminProfileCheck.jsp");


    }
}

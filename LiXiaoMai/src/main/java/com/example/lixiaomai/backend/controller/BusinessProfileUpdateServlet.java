package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.entity.Deliverman;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.DelivermanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/businessProfileUpdate")

public class BusinessProfileUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String shopName = request.getParameter("shopName");
        String name=request.getParameter("name");
        String uName = request.getParameter("uName");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String address=request.getParameter("address");
        String idCard=request.getParameter("idCard");
        int status = Integer.parseInt(request.getParameter("status"));

        Business business=new Business();
        business.setId(id);
        business.setName(name);
        business.setUName(uName);
        business.setShopName(shopName);
        business.setPassword(password);
        business.setTelephone(telephone);
        business.setAddress(address);
        business.setIdCard(idCard);
        business.setStatus(status);

        BusinessService businessService=new BusinessService();
        businessService.updateBusiness(business);

        HttpSession session=request.getSession();
        session.setAttribute("business",business);
        request.getRequestDispatcher("businessIndex.jsp").forward(request, response);
    }
}

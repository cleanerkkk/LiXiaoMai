package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.DelivermanService;
import com.example.lixiaomai.backend.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DefaultEditorKit;
import java.io.IOException;
import java.util.List;
@WebServlet("/ProfileSettings")
public class ProfileSettingsServlet  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String userType = (String) session.getAttribute("userType");
        String name = (String) session.getAttribute("name");
        Customer customer=new Customer();
        CustomerService customerService=new CustomerService();
        customer=customerService.getUserByUsername(name);
        session.setAttribute(userType,"userType");
        session.setAttribute(name,"name");
        session.setAttribute("customer",customer);
        request.getRequestDispatcher("profileSettings.jsp").forward(request,response);



    }
}

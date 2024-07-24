package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/profileSettingsUpdate")
public class ProfileSettingsUpdateServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String uName = request.getParameter("uName");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String gender = request.getParameter("gender");
        Date birthday= Date.valueOf(request.getParameter("birthday"));
        String address=request.getParameter("address");

        Customer customer=new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setUName(uName);
        customer.setPassword(password);
        customer.setTelephone(telephone);
        customer.setGender(gender);
        customer.setBirthday(birthday);
        customer.setAddress(address);

        CustomerService customerService=new CustomerService();
        customerService.updateCustomerInfo(id,customer);

        HttpSession session=request.getSession();
        session.setAttribute("customer",customer);
        request.getRequestDispatcher("profileSettings.jsp").forward(request, response);
    }
}

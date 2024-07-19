package com.example.lixiaomai.backend.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String registerType = request.getParameter("registerUser");
        String registerUserName = request.getParameter("registerUserName");
        String registerPassword = request.getParameter("registerPassword");
        String registerName = request.getParameter("registerName");



    }
}

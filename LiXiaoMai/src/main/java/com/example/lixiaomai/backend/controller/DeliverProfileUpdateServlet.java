package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Deliverman;
import com.example.lixiaomai.backend.service.DelivermanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deliverProfileUpdate")
public class DeliverProfileUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String uName = request.getParameter("uName");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String gender = request.getParameter("gender");
        String vType = request.getParameter("vType");
        int vId = Integer.parseInt(request.getParameter("vId"));
        String vBrand = request.getParameter("vBrand");
        int status = Integer.parseInt(request.getParameter("status"));

        Deliverman deliverman = new Deliverman();
        deliverman.setId(id);
        deliverman.setName(name);
        deliverman.setUName(uName);
        deliverman.setPassword(password);
        deliverman.setTelephone(telephone);
        deliverman.setGender(gender);
        deliverman.setVType(vType);
        deliverman.setVId(vId);
        deliverman.setVBrand(vBrand);
        deliverman.setStatus(status);
        DelivermanService delivermanService=new DelivermanService();
        delivermanService.updateDelivermanInfo(id,deliverman);

        HttpSession session=request.getSession();
        session.setAttribute("deliverman", deliverman);
        request.getRequestDispatcher("delivermanIndex.jsp").forward(request, response);
    }
}

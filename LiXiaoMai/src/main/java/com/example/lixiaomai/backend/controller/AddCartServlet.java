package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Cart;
import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String quantitiesParam = request.getParameter("quantities");
        String idsParam = request.getParameter("ids");
        String userName = request.getParameter("userId");

        if (quantitiesParam == null || idsParam == null) {
            response.sendRedirect("error.jsp");
            return;
        }

        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getUserByUsername(userName);
        int cId = customer.getId();

        List<Integer> gId = new ArrayList<>();
        List<Integer> goodsNum = new ArrayList<>();

        List<String> quantitiesList = Arrays.asList(quantitiesParam.replace("[", "").replace("]", "").split(","));
        List<String> idsList = Arrays.asList(idsParam.replace("[", "").replace("]", "").split(","));

        for (int i = 0; i < idsList.size(); i++) {
            gId.add(Integer.parseInt(idsList.get(i).trim()));
            goodsNum.add(Integer.parseInt(quantitiesList.get(i).trim()));
        }

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            cart.setCId(cId);
            cart.setGId(gId);
            cart.setGoodsNum(goodsNum);
        } else {
            List<Integer> existingGId = cart.getGId();
            List<Integer> existingGoodsNum = cart.getGoodsNum();

            for (int i = 0; i < gId.size(); i++) {
                int index = existingGId.indexOf(gId.get(i));
                if (index != -1) {
                    existingGoodsNum.set(index, existingGoodsNum.get(index) + goodsNum.get(i));
                } else {
                    existingGId.add(gId.get(i));
                    existingGoodsNum.add(goodsNum.get(i));
                }
            }

            cart.setGId(existingGId);
            cart.setGoodsNum(existingGoodsNum);
        }

        session.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}

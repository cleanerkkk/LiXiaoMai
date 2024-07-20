package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServlet;

@WebServlet("/exhibit")
public class ExhibitServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 4;
        String x = request.getParameter("page");

        if (x != null) {
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        BusinessService businessService = new BusinessService();
        ProductService productService = new ProductService();
        List<Business> userList = businessService.getAllBusiness();
        Map<Integer,List<Product>> productMap = new HashMap<>();
        //整合map
        for (Business business : userList) {
            int id = business.getId();
            List<Product> list = productService.getAllProductBySid(id);
            productMap.put(id,list);
        }

        int allRecords = userList.size();
        int totalPages = (int) Math.ceil(allRecords * 1.0 / recordsPerPage);

        int start = (page - 1) * recordsPerPage;
        int end = Math.min(start + recordsPerPage, allRecords);
        List<Business> paginatedList = userList.subList(start, end);

        request.setAttribute("BusinessList", paginatedList);
        request.setAttribute("ProductMap", productMap);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", page);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}

package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

@WebServlet("/businessManage")
@MultipartConfig
public class BusinessManageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        String name = (String) session.getAttribute("name");

        BusinessService businessService = new BusinessService();
        Business business=businessService.getBusinessById(id);
        String shopName=business.getShopName();
        ProductService productService = new ProductService();

        List<Product> productList = productService.getAllProductBySid(id);
        request.setAttribute("productList", productList);
        request.setAttribute("business",business);
        request.setAttribute("id",id);
        request.setAttribute("shopName",shopName);
        request.getRequestDispatcher("businessManage.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        String name = (String) session.getAttribute("name");

        BusinessService businessService = new BusinessService();
        ProductService productService = new ProductService();

        String action = request.getParameter("action");
        String productName = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String stockx = request.getParameter("stock");
        int stock = 0;
        if (stockx != null) {
            stock = Integer.parseInt(stockx);
        }
        String type = request.getParameter("type");
        String productIdx = request.getParameter("productId");
        int productId = 0;
        if (productIdx != null) {
            productId = Integer.parseInt(productIdx);
        }

        Part filePart = request.getPart("image");
        String filePath = request.getServletContext().getRealPath("/imgsrc/") + productName +".jpg";

        InputStream fileContent = filePart.getInputStream();

        File file = new File(filePath);
        try (OutputStream output = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileContent.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        }catch (IOException e) {
            System.err.println("图片保存失败：" + e.getMessage());
            e.printStackTrace();
        }


        Product product = new Product();
        product.setName(productName);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        product.setSId(id);
        product.setPitcutreUrl(filePath);
        product.setType(type);


        if (action.equals("add") ) {
            productService.addProduct(product);
            doGet(request, response);
            return;
        } else if (action.equals("update") ){
            product.setId(productId);
            productService.updateProduct(product);
        } else if (action.equals("delete")) {
            productService.deleteProductById(productId);
        }
        doGet(request, response);

    }
}


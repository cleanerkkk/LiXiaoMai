package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.service.ProductService;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/getImage")
public class GetImageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        ProductService productService = new ProductService();
        Product product = productService.getProductById(id);
        String urll = productService.getPictureUrl(id);

        String path = product.getUrl();
        path = path.substring(path.indexOf("imgsrc"));
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
        BufferedImage image = null;
        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("image/jpg");
        javax.imageio.ImageIO.write(image, "jpg", response.getOutputStream());

    }
}

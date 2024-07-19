package com.example.lixiaomai.backend.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CaptchaServlet")
public class CaptchaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        String captchaText = generateCaptcha();
        String timestamp = request.getParameter("t");
        HttpSession session = request.getSession();
        session.setAttribute("captchaValue", captchaText);
        BufferedImage captchaImage = generateCaptchaImage(captchaText, 70, 20);
        response.setContentType("image/png");
        javax.imageio.ImageIO.write(captchaImage, "png", response.getOutputStream());
    }

    public  String generateCaptcha(){
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int length = 4;
        Random random = new Random();
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charset.length());
            captcha.append(charset.charAt(index));
        }
        return captcha.toString();
    }

    public BufferedImage  generateCaptchaImage(String captchaText, int width, int height){
        BufferedImage  captchaImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = captchaImage.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        Font font = new Font("Arial", Font.BOLD, 16);
        g2d.setFont(font);

//        g2d.setColor(Color.BLACK);
        FontMetrics fm = g2d.getFontMetrics(font);
        int textWidth = fm.stringWidth(captchaText);
        int sX = (width - textWidth) / 2; // 图像宽度减去验证码文本宽度的一半
        int sY = height - font.getSize()/2; // 图像高度减去字体高度


        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int startX = random.nextInt(width);
            int startY = random.nextInt(height);
            int endX = random.nextInt(width);
            int endY = random.nextInt(height);
            g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            g2d.drawLine(startX, startY, endX, endY);
        }
        g2d.drawString(captchaText, sX, sY);
        g2d.dispose();
        return captchaImage;
    }
}
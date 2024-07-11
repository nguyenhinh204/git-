package com.example.demo.buoi2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        request.getRequestDispatcher("buoi2/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay gia tri usr va pwd tu trong form
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        // Truyen gia tri usr va pwd sang mot trang jsp moi
        request.setAttribute("usr", usr);
        request.setAttribute("pwd", pwd);
        // Tra ve trang jsp ket qua
        request.getRequestDispatcher("buoi2/ket-qua.jsp").forward(request, response);
    }
}

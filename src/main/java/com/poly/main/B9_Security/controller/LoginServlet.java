package com.poly.main.B9_Security.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi9/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay ra gia tri
        String name = request.getParameter("uname");
        String pass = request.getParameter("pass");
        // B2: Check tai khoan va mat khau
        // Co the thay the lay tu CSDL
        // hangnt169 & 123456 => admin
        // test123 & 1234567 => nhan vien
       if(
               (name.equalsIgnoreCase("hangnt169") && pass.equals("123456")) ||
                       (name.equalsIgnoreCase("test123") && pass.equals("1234567"))
       ){
           // tai khoan hop le
           HttpSession session = request.getSession();
           session.setAttribute("username",name); // Dung o moi noi khac
           // Quay ve trang bai-hat
           response.sendRedirect("/bai-hat/hien-thi"); // Co the thay the bang 1 trang servlet khac tuy
       }else{
           // khong hop le
           request.setAttribute("error","Tai khoan hoac mat khau khong hop le");
           request.getRequestDispatcher("/buoi9/login.jsp").forward(request,response);
       }
    }
}

package com.poly.main.B8_ScopeJSP;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Servlet2", value = "/Servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Cach goi ben servlet
        HttpSession s = request.getSession();
        String test = (String) s.getAttribute("bienSession");
        // application cung giong session
        // phien lam viec cua session:30 phut
        // application k co thoi gian chet. chi chet khi chuong trinh dung hoat dong
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

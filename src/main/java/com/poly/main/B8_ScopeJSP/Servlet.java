package com.poly.main.B8_ScopeJSP;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("test1","chao ban");
        // Session: Khi nao can dung session
        HttpSession s = request.getSession();
        s.setAttribute("bienSession","Gia tri bien session");
        request.getRequestDispatcher("/buoi8/jsp1.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

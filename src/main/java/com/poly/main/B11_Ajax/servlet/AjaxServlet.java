package com.poly.main.B11_Ajax.servlet;

import com.google.gson.Gson;
import com.poly.main.B11_Ajax.entity.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", value = "/api/sinh-vien/detail")
public class AjaxServlet extends HttpServlet {
    // tao ra json => jsp nhan ve va doc json
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Tao 1 doi tuong sinh vien (Tuy de co the tao ra 1 list doi tuong)
        SinhVien sv = new SinhVien("HE130461","Nguyen Van A",10);
        // B2: Chuyen doi du lieu =>Gson
        Gson gson = new Gson();
        // Chuyen doi tu gson -> json
        String responseData = gson.toJson(sv);
        // B3: Set type dinh dang chuyen doi
        response.setContentType("application/json");
        // B4: Muon hien thi du lieu len trinh duyet
        PrintWriter out =  response.getWriter();
        // B5: Gui du lieu cho client
        out.println(responseData);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

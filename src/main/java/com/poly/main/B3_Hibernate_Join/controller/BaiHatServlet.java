package com.poly.main.B3_Hibernate_Join.controller;

import com.poly.main.B3_Hibernate_Join.repository.BaiHatRepository;
import com.poly.main.B3_Hibernate_Join.repository.CaSiRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BaiHatServlet", value = "/bai-hat/hien-thi")
public class BaiHatServlet extends HttpServlet {

    private BaiHatRepository baiHatRepository = new BaiHatRepository();

    private CaSiRepository caSiRepository = new CaSiRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiDuLieu(request, response);
        }
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listBaiHat", baiHatRepository.getAll());
        request.setAttribute("listCaSi", caSiRepository.getAll());
        request.getRequestDispatcher("/buoi3/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

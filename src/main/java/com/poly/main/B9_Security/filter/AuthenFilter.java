package com.poly.main.B9_Security.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenFilter", value = {
        // liet ke cac duong dan ma bat buoc phai check dang nhap
        "/bai-hat/*",
        "/category/*",
        "/test-user"
})
public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // authen & author:
        // authen: check tai khoan va mat khau co ton tai trong he thong hay khong
        // 401: tai khoan mat khau khong hop le
        // author: phan quyen nguoi dung => dang nhap truoc
        // 403: tai khoan mat khau khong duoc truy cap
        // B1: Ep kieu request & response ve loai HTTP
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // B2: Goi session
        HttpSession sess = req.getSession();
        String username = (String) sess.getAttribute("username");
        // Check tai khoan thuoc quyen gi de truy cap cho phu hop(Author): Check o if hay else
        if (username == null) {
            // Chua dang nhap =>Quay ve trang login
            res.sendRedirect("/login");
        } else {
            String role = (String) sess.getAttribute("role");
            if (role.equalsIgnoreCase("admin")) {
                chain.doFilter(request, response); // Da dang nhap
            } else if (role.equalsIgnoreCase("user")) {
                // user => /test-user
                String uri = req.getRequestURI(); // Lay ra uri hien tai tren duong dan
                if (uri.contains("test-user")) {
                    res.sendRedirect("/buoi9/test3.jsp");
                }else{
                    // k hop le => 403
                    res.sendRedirect("/buoi9/403-page.jsp");
                }
            } else {
                // TH con lai => Vai tro k hop le
                res.sendRedirect("/login");
            }
        }
    }
}

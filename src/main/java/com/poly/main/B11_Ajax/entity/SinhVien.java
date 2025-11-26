package com.poly.main.B11_Ajax.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SinhVien {
    // Tao doi tuong SinhVien:
    // ma - String
    // ten - String
    // tuoi - int
    // Tao 1 ajax: "/api/sinh-vien/detail" hien thi du liẹu ra man hinh len giao dien

    private String ma;

    private String ten;

    private int tuoi;

}

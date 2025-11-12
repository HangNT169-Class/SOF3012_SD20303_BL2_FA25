package com.poly.main.B5_PhanTrang_Search.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "phieu_giam_gia")
@ToString
public class PhieuGiamGia {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Nationalized
    @Column(name = "ten")
    private String ten;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Nationalized
    @Column(name = "loai_giam")
    private String loaiGiam;

    @Column(name = "dieu_kieu_toi_thieu")
    private String dieuKieuToiThieu;

    @Column(name = "gia_tri_toi_da")
    private String giaTriToiDa;

}
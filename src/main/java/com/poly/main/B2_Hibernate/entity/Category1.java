package com.poly.main.B2_Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // danh dau la 1 thuc the
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString // in ro thong tin cua doi tuong
public class Category1 {
    // Truy van SQL => *
    // Truy van entity(Truy van truc tiep tren thuc the) => HQL(Hibernate Query Language)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY: tu tang. Co the chon loai khac
    // UUID: AUTO
    private Long id;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}

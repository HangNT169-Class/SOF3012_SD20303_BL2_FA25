package com.poly.main.B3_Hibernate_Join.repository;

import com.poly.main.B3_Hibernate_Join.entity.BaiHat;
import com.poly.main.B3_Hibernate_Join.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class BaiHatRepository {

    private Session s;

    public BaiHatRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<BaiHat> getAll() {
        return s.createQuery("FROM BaiHat ").list();
    }

    public static void main(String[] agrs) {
        System.out.println(new BaiHatRepository().getAll());
    }
}

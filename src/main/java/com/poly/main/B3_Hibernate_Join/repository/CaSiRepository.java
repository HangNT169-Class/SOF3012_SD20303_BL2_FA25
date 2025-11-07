package com.poly.main.B3_Hibernate_Join.repository;

import com.poly.main.B3_Hibernate_Join.entity.CaSi;
import com.poly.main.B3_Hibernate_Join.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CaSiRepository {

    private Session s;

    public CaSiRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<CaSi> getAll() {
        return s.createQuery("FROM CaSi").list();
    }

    public static void main(String[] args) {
        System.out.println(new CaSiRepository().getAll());
    }
}

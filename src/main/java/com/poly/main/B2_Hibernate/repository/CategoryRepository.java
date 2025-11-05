package com.poly.main.B2_Hibernate.repository;

import com.poly.main.B2_Hibernate.entity.Category1;
import com.poly.main.B2_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {

    private Session s;

    public CategoryRepository() {
        s = HibernateUtil.getFACTORY().openSession(); // MO 1 PHIEN SESSION
    }

    public List<Category1> getAll() {
//        String hql ="SELECT cate FROM Category1 cate";
        return s.createQuery("FROM Category1").list();
    }

    public Category1 getOne(Long id) {
        return s.find(Category1.class, id);
    }

    // transation => D,U,A

    public void add(Category1 cate){
        try{
            // B1: Bat dau 1 tran
            s.getTransaction().begin();
            // B2: Thuc hien chuc nang
            // => add: persist
            // => saveOrUpdate
            // => save
            s.persist(cate);
            // B3: day du lieu commit
            s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
            // Loi thi rollback lai trang thai ban dau
            s.getTransaction().rollback();
        }
    }

    public void update(Category1 cate){
        try{
            // B1: Bat dau 1 tran
            s.getTransaction().begin();
            // B2: Thuc hien chuc nang
            // => update: merge
            // => saveOrUpdate
            s.merge(cate);
            // B3: day du lieu commit
            s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
            // Loi thi rollback lai trang thai ban dau
            s.getTransaction().rollback();
        }
    }

    public void delete(Category1 cate){
        try{
            // B1: Bat dau 1 tran
            s.getTransaction().begin();
            // B2: Thuc hien chuc nang
            // => delete
            s.delete(cate);
            // B3: day du lieu commit
            s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
            // Loi thi rollback lai trang thai ban dau
            s.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        // new Class().tenHam
//        System.out.println(new CategoryRepository().getAll());
        System.out.println(new CategoryRepository().getOne(1L));
    }
}

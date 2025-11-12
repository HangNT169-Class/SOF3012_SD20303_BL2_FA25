package com.poly.main.B5_PhanTrang_Search.repository;

import com.poly.main.B5_PhanTrang_Search.entity.PhieuGiamGia;
import com.poly.main.B5_PhanTrang_Search.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class PhieuGiamGiaRepository {
    private Session s;

    public PhieuGiamGiaRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    // C1: Su ham co san cua hibernate => find
    // C2: lam ca search
    public PhieuGiamGia getOne(int id1) {
        // B1: Viet HQL: truyen vi tri dang sau dau ?
        String hql = " SELECT p FROM PhieuGiamGia p WHERE p.id = ?1";
        // B2: Tao query => chon cua jakatar
        Query q = s.createQuery(hql);
        // B3: Set gia tri cho dau ? => setParameter
        q.setParameter(1, id1);
        // B4: Return gia tri
        // neu ham danh sach => getResultList
        // neu tra 1 doi tuong => getSingleResult
        return (PhieuGiamGia) q.getSingleResult();
    }

    // Search theo ten hoac khoang so luong
    public List<PhieuGiamGia> search(String ten, int soLuongMax, int soLuongMin) {
        String hql = "SELECT p FROM PhieuGiamGia p WHERE p.ten LIKE ?1 " +
                "OR (p.soLuong >= ?2 AND p.soLuong <= ?3)";
        Query q = s.createQuery(hql);
        q.setParameter(1, "%" + ten + "%");
        q.setParameter(2, soLuongMin);
        q.setParameter(3, soLuongMax);
        return q.getResultList();
    }
    // Sap xep danh sach phieu giam gia giam dan theo so luong
    public List<PhieuGiamGia> sort() {
        String hql = "SELECT p FROM PhieuGiamGia p ORDER BY p.soLuong DESC";
        Query q = s.createQuery(hql);
        return q.getResultList();
    }
    // phan trang => dung offset trong SQL
    /**
     * -- giai thich ham nay la gi lam gi
     *
     * @param pageNo:   gt gia tri cua bien nay: so Trang (trang so 1, trang 2..)
     * @param pageSize: so luong phan tu trong 1 trang
     * @return : gt gia tri tra ve
     */
    public List<PhieuGiamGia> phanTrangSQl(Integer pageNo, Integer pageSize) {
        // TRANG DAU TIEN BAT DAU BANG 0
        Integer offset1 = pageNo * pageSize;
        // B1: Tao cau lenh SQL
//        String sql = "SELECT * from category " +
//                "ORDER BY id  " +
//                "OFFSET :offset ROWS \n" +
//                "FETCH NEXT :pageSize1 ROWS ONLY ";
        String sql = "select * from phieu_giam_gia ORDER BY id  OFFSET :offset ROWS FETCH NEXT :pageSize1 ROWS ONLY;";
//        String sql1="select * from category\n" +
//                "ORDER BY id \n" +
//                "OFFSET9 ROWS \n" +
//                "FETCH NEXT 3 ROWS ONLY ";
        // B2: Tao query
        Query query = s.createNativeQuery(sql, PhieuGiamGia.class);
        // B3: Set value
        query.setParameter("offset",offset1);
        query.setParameter("pageSize1",pageSize);
        return  query.getResultList();
    }

    public List<PhieuGiamGia>phanTrangHQl(Integer pageNo, Integer pageSize){
        int offset = pageNo * pageSize;
        String hql = "SELECT p FROM PhieuGiamGia p  ORDER BY p.id ";
        Query query = s.createQuery(hql);
        query.setFirstResult(offset); // NGANG HANG VS OFFSET => KET QUA TRA RA LA +1
        query.setMaxResults(pageSize); // SO LUONG MAX/TRANG
        return  query.getResultList();
    }
    public static void main(String[] args) {
        System.out.println(new PhieuGiamGiaRepository().getOne(1));
    }
}

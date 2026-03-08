package com.inventory.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.loader.ProductDataLoader;   // ADD THIS IMPORT
import com.inventory.util.HibernateUtil;

public class HQLDemo {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {

            //ProductDataLoader.loadSampleProducts(session);

            sortProductsByPriceAscending(session);
            sortProductsByPriceDescending(session);
            sortProductsByQuantityDescending(session);
            getFirstThreeProducts(session);
            countTotalProducts(session);

        } finally {
            session.close();
            factory.close();
        }
    }

    public static void sortProductsByPriceAscending(Session session) {

        String hql = "FROM Product p ORDER BY p.price ASC";

        Query<Product> query = session.createQuery(hql, Product.class);
        List<Product> products = query.list();

        System.out.println("Price ASC");

        for (Product p : products) {
            System.out.println(p.getName() + " " + p.getPrice());
        }
    }

    public static void sortProductsByPriceDescending(Session session) {

        String hql = "FROM Product p ORDER BY p.price DESC";

        Query<Product> query = session.createQuery(hql, Product.class);
        List<Product> products = query.list();

        System.out.println("Price DESC");

        for (Product p : products) {
            System.out.println(p.getName() + " " + p.getPrice());
        }
    }

    public static void sortProductsByQuantityDescending(Session session) {

        String hql = "FROM Product p ORDER BY p.quantity DESC";

        Query<Product> query = session.createQuery(hql, Product.class);
        List<Product> products = query.list();

        System.out.println("Quantity DESC");

        for (Product p : products) {
            System.out.println(p.getName() + " " + p.getQuantity());
        }
    }

    public static void getFirstThreeProducts(Session session) {

        String hql = "FROM Product";

        Query<Product> query = session.createQuery(hql, Product.class);

        query.setFirstResult(0);
        query.setMaxResults(3);

        List<Product> products = query.list();

        System.out.println("First 3 Products");

        for (Product p : products) {
            System.out.println(p);
        }
    }

    public static void countTotalProducts(Session session) {

        String hql = "SELECT COUNT(p) FROM Product p";

        Query<Long> query = session.createQuery(hql, Long.class);

        Long count = query.uniqueResult();

        System.out.println("Total products = " + count);
    }
}
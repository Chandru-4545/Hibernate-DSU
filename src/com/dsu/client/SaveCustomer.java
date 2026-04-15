package com.dsu.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dsu.entity.Customer;

public class SaveCustomer {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();

            Customer c1 = new Customer("Anu", "anu@gmail.com", "9876543210");
            Customer c2 = new Customer("Rahul", "rahul@gmail.com", "9123456780");

            session.persist(c1);
            session.persist(c2);

            session.getTransaction().commit();

            System.out.println("Customers saved successfully");
            System.out.println(c1);
            System.out.println(c2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}
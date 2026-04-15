package com.dsu.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dsu.entity.Customer;

public class ReadCustomer {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();

            int customerId = 1;
            Customer customer = session.get(Customer.class, customerId);

            if (customer != null) {
                System.out.println("Customer found:");
                System.out.println(customer);
            } else {
                System.out.println("Customer not found with id = " + customerId);
            }

            session.getTransaction().commit();

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
package com.dsu.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dsu.entity.Customer;

public class DeleteCustomer {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();

            int customerId = 2;
            Customer customer = session.get(Customer.class, customerId);

            if (customer != null) {
                session.remove(customer);
                System.out.println("Customer deleted successfully");
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
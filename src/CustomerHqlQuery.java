package com.dsu.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dsu.entity.Customer;

public class CustomerHqlQuery {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()   // loads hibernate.cfg.xml
                .addAnnotatedClass(Customer.class) // ✅ IMPORTANT
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            // 🔹 Fetch all records
            System.out.println("\n--- ALL CUSTOMERS ---");
            List<Customer> customers = session
                    .createQuery("from Customer", Customer.class)
                    .list();
            display(customers);

            // 🔹 AND condition
            System.out.println("\n--- AND CONDITION ---");
            List<Customer> customers2 = session.createQuery(
                    "from Customer where name like '%a%' and email like '%gmail.com'",
                    Customer.class).list();
            display(customers2);

            // 🔹 OR condition
            System.out.println("\n--- OR CONDITION ---");
            List<Customer> customers3 = session.createQuery(
                    "from Customer where name like '%a%' or phone like '9%'",
                    Customer.class).list();
            display(customers3);

            // 🔹 Aggregate function
            System.out.println("\n--- AGGREGATE FUNCTIONS ---");
            Long count = session.createQuery(
                    "select count(c) from Customer c", Long.class)
                    .getSingleResult();
            System.out.println("Total Customers: " + count);

            // 🔹 Fetch single record
            System.out.println("\n--- SINGLE RECORD ---");
            Customer cust = session.get(Customer.class, 1);
            System.out.println(cust);

            // 🔹 Native SQL
            System.out.println("\n--- NATIVE SQL QUERY ---");
            List<Object[]> data = session.createNativeQuery(
                    "select id, name, email, phone from customer")
                    .list();

            for (Object[] row : data) {
                System.out.println(
                        row[0] + " | " + row[1] + " | " + row[2] + " | " + row[3]);
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();   // ✅ prevent leak
            factory.close();
        }
    }

    public static void display(List<Customer> customers) {
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}
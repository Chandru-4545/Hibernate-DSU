# Hibernate Customer CRUD Demo

This is a simple Hibernate project that saves `Customer` data into a MySQL database.

## Project Description

This project demonstrates how to use Hibernate ORM with MySQL to:

- Map a Java entity class to a database table.
- Configure Hibernate using `hibernate.cfg.xml`.
- Save customer records into the database.
- Automatically create or update the table structure using Hibernate.

## Technologies Used

- Java
- Hibernate ORM 5.3.25.Final
- MySQL
- JDBC
- Jakarta Persistence API

## Features

- Entity mapping using `@Entity`
- Auto-generated primary key using `@GeneratedValue`
- MySQL database connection
- Insert/save customer records
- Hibernate configuration using XML

## Project Structure

```text
HibernateProject/
├── src/main/java/
│   ├── com/dsu/entity/
│   │   └── Customer.java
│   └── com/dsu/client/
│       └── SaveCustomer.java
├── src/main/resources/
│   └── hibernate.cfg.xml
└── pom.xml
```

## Database Setup

Create a MySQL database named:

```sql
CREATE DATABASE dsu;
```

## Hibernate Configuration

Update `hibernate.cfg.xml` with your MySQL username and password.

Example:

```xml
<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/dsu?allowPublicKeyRetrieval=true&amp;useSSL=false&amp;serverTimezone=UTC
</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">your_password_here</property>
```

## How to Run

1. Clone or download the project.
2. Open it in Eclipse or IntelliJ IDEA.
3. Make sure MySQL is running.
4. Create the database `dsu`.
5. Update the password in `hibernate.cfg.xml`.
6. Run the `SaveCustomer.java` file as a Java application.

## Expected Output

When the project runs successfully, Hibernate will:

- connect to MySQL,
- create the `customer` table if needed,
- insert customer records,
- print the saved customer details in the console.

Example output:

```text
Customers saved successfully
Customer [id=1, name=Anu, email=anu@gmail.com, phone=9876543210]
Customer [id=2, name=Rahul, email=rahul@gmail.com, phone=9123456780]
```

## Common Issues

### Access denied for user root
Make sure the password in `hibernate.cfg.xml` is correct.

### Public Key Retrieval is not allowed
Use this JDBC URL parameter:

```text
allowPublicKeyRetrieval=true
```

### Table not found
Make sure Hibernate is connected to the correct database and the entity is mapped properly.

## Author

Created by Chandru M.

## License

This project is for learning and practice purposes.

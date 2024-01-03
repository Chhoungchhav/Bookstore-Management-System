# Bookstore-Management-System

## Introduction
The Bookstore Management System keeps you in the loop with real-time updates on purchases and supplies. It helps with tasks like finding popular books, recognizing regular customers, and keeping track of sales and profits.
## Features
**1. Manager**<br/>

  Add Customer

  Check Popular Books

  Check Regular Customers

  Check Salary

**2. Seller**<br/>

  Add Purchase

  Add Book

  Add Customer

  Check Salary<br/>

## Object-Oriented Features

### Classes & Objects
We have in total of 11 classes:
- Authenticate
- Book
- Customer
- Employee
- LogIn
- Manager
- Operation
- OperationManager
- OperationSeller
- Register
- Seller

### Inheritance
Inheritance is employed to create a hierarchy of classes. We have 2 Super classes:
- **Employee** serves as **SuperClass**, while both **Manager** class and **Seller** class are **sub-classes** that inherit the constructor of **Employee**.
- **OperationManager** and **OperationSeller** are also **sub-classes** extended from the **Operation**. 

### Polymorphism
Polymorphism is implemented through method overloading and overriding.<br/>
**Overloading:**
- In **Employee.java** both constructors showcasing the flexibility provided by constructor overloading.<br/>
  Store the Employee detail<br/>

      public Employee(int employeeID, String name, String password, String emailAddress, String startDate)
  Store the Login detail of Employee<br/>

      public Employee(int employeeID, String password)
- Similarly in **Book.java** There is also  overloading constructor. <br/>
  Store the Book detail<br/>

      public Book(int bookID, String title, double salePrice, double importPrice, String importDate)
  Store the Amount of Book Purchase<br/>

      public Book(int bookID, int bookCount)

**Override:**
The **"@Override"** annotation in Java is used to indicate that a method in a subclass is intended to override a method of the superclass. Overriding allows a subclass to provide a specific implementation of a method that is already provided by its superclass.

### Abstraction
We have 1 abstract class, which is Operation. It has the abstract method runOperation, and a protected method addCustomer.

### Exception Handling

### File I/O
We have 4 .txt files:
- **Book:** to store bookID, book title, sale price, import price, import date
- **Customer:** to store customerID, name, phone number
- **Employee:** to store employeeID, name, password, email, start date, position
- **Purchase:** to store purchaseID, customerID, sellerID, bookID, quantity, total price, purchase date

### Lambda Expression

### Static method:


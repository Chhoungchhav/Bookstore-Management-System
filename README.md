# Bookstore-Management-System

## Introduction
The Bookstore Management System keeps you in the loop with real-time updates on purchases and supplies. It helps with tasks like finding popular books, recognizing regular customers, and keeping track of sales and profits.
## Features
**1. Authentication**<br/>
- Log in
- Register

**2. Manager**<br/>
  - Add Customer
  - Check Popular Books
  - Check Regular Customers
  - Check Salary

**3. Seller**<br/>
- Add Purchase
- Add Book
- Add Customer
- Check Salary<br/>

## Object-Oriented Features

### Classes & Objects

We have a total of 11 classes:
- Authenticate: 
Run log in and regsiter 
- Book
- Customer
- Employee
- Login: 
Logging employee in and verify existing employee ID
- Manager
- Operation
- OperationManager: 
Includes all the function that manager can perform
- OperationSeller: 
Includes all the function that seller can perform
- Register: 
Register new employee
- Seller: 

### Inheritance

Inheritance is employed to create a hierarchy of classes. We have 2 Super classes:
- **Employee** serves as **SuperClass**, while both **Manager** class and **Seller** class are **sub-classes** that inherit the constructor of **Employee**.
- **OperationManager** and **OperationSeller** are also **sub-classes** extended from the **Operation**. 

### Polymorphism
Polymorphism is implemented through method overloading and overriding.<br/>
**Overloading**
- In **Employee.java** both constructors showcasing the flexibility provided by constructor overloading.<br/>
  Store the Employee detail<br/>

      public Employee(int employeeID, String name, String password, String emailAddress, String startDate)
  
  Store the Login detail of Employee<br/>

      public Employee(int employeeID, String password)
  
- Similarly in **Book.java** There is also an overloading constructor. <br/>
  Store the Book detail<br/>

      public Book(int bookID, String title, double salePrice, double importPrice, String importDate)
  Store the Amount of Book Purchase<br/>

      public Book(int bookID, int bookCount)

**Override**

The **"@Override"** annotation in Java is used to indicate that a method in a subclass is intended to override a method of the superclass. Overriding allows a subclass to provide a specific implementation of a method that is already provided by its superclass.
- In **Manager.java**, **Seller.java**, and **Employee.java**, as **Manager** and **Seller** are sub-classes to **Employee** the **@Override** allows the **Manager** and **Seller** can override and provide a custom representation of an object.
- Same as before the **Operation.java**, **OperationSeller.java**, and **OperationManager.java** also have the **@Override** annotation to override the object in **OperationSeller** and **OperationManager**.

### Encapsulation

-**public**: Can be accessed from any part within the same program which almost has in the **Book.java**, **Customer.java**, **Register.java**, and **Login.java**.

-**private**: Can only be accessible within the same class and not visible to subclasses or other classes and can be found in **Manager.java**, **Seller.java**, **OperationManager.java**, **OperationSeller.java**, and **Authentication.java**.

-**protected**: Can be accessible within the same class, its subclasses, **Operation.java** and **Employee.java** have this modifier.

### Abstraction

We have 1 abstract class that is implemented in **Operation.java** and used to enforce implementation in a subclass. 

    public abstract void runOperation();

### Exception Handling
Exception handling is incorporated to gracefully manage unexpected errors. This ensures the system can recover or gracefully terminate, we implement this to ensure the **file is not found** issue and the **mistype input** issue by using **'try'** and **'catch'**

### File I/O

We have 4 files:
- **Book.txt:** to store bookID, book title, sale price, import price, import date
- **Customer.txt:** to store customerID, name, phone number
- **EmployeeInfo.txt:** to store employeeID, name, password, email, start date, position
- **Purchase.txt:** to store purchaseID, customerID, sellerID, bookID, quantity, total price, purchase date

### Lambda Expression
Lambda expressions enhance the system's flexibility and conciseness. We also implement **'filter'** and **'max'**.
- **'filter'** is a function we use to simplify the process of selecting elements that meet certain criteria.
- We use the function **'max'** to find the maximum element in a collection

### Static method
**'static'** method we use to access the class without creating an instance of the class. In the project, we use **21** static methods.


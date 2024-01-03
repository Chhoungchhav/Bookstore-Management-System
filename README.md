# Bookstore-Management-System
The Bookstore Management System keeps you in the loop with real-time updates on purchases and supplies. It helps with tasks like finding popular books, recognizing regular customers, and keeping track of sales and profits.

Classes & Objects:
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

Inheritance:
We have 2 Super classes:
- Employee which has sub class Manager and Seller
- Operation which has sub class OperationManager and OperationSeller

Polymorphism:

Abstraction:
We have 1 abstract class, which is Operation. It has the abstract method runOperation, and a protected method addCustomer.

Exception Handling:

File I/O:
We have 4 .txt files:
- Book: to store bookID, book title, sale price, import price, import date
- Customer: to store customerID, name, phone number
- Employee: to store employeeID, name, password, email, start date, position
- Purchase: to store purchaseID, customerID, sellerID, bookID, quantity, total price, purchase date

Lambda Expression:

Static method:


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
- Authenticate: Run log in and register 
- Book: creating a book list, storing the data for book, and verify the book
- Customer: identifying the customer and store the customer
- Employee: cast to manager or seller 
- Login: Logging employee in and verify existing employee ID
- Manager: identifying the user to be a manager
- Operation: manager the operation to the manager or seller
- OperationManager: Includes all the functions that the manager can perform
- OperationSeller: Includes all the functions that the seller can perform
- Register: Register new employee
- Seller: identity the seller, add purchase info, and verify the purchase 

### Inheritance

Inheritance is employed to create a hierarchy of classes. We have 2 Super classes:
- **Employee** serves as **SuperClass**, while both **Manager** class and **Seller** class are **sub-classes** that inherit the constructor of **Employee**.
In this case, we use inheritance for better code structure as seller and manager are both Employee. It is also for code reusability such as the getSalary method, and for specialization because even if seller and manager are both employee, they have different salary, and different function available to them.
- **OperationManager** and **OperationSeller** are also **sub-classes** extended from the **Operation**. 
We use inheritance for this because it can provide reusable code for addCustomer method, as both the operationManager and operationSeller need it.

### Polymorphism

**Casting**
We create manager as an employee first before casting it into manager because at the start, we only know that the user is employee, and after we get the position, we can cast them to specific class.

    Employee tmp2 = new Manager(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4]);
    mList.add((Manager)tmp2);
    
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

-**public**: Can be accessed from any other class or package. We use public on methods so that it can be use in other classes.

    public int getEmployeeID(){
        return employeeID;
    }

-**private**: Can only be accessible within the same class and not visible to subclasses or other classes. We use private on every field to ensure their the value can only be changed inside that class and cannot be modified by any external classes.

    private int bookID, bookCount;
    private String title;
    private double salePrice, importPrice;

We also use private on some methods as well:

    private JPanel registerUser() {

-**protected**: Can be accessible within its own package and by subclasses, whether they are in the same package or not.</br>
We use it inmethod in **Operation.java**

    protected JPanel addCustomer() {

and **Employee.java**

    protected static boolean addCustomer(int tmpCutomerID, String name, String phoneNumber){

### Abstraction

We have 1 abstract class that is implemented in **Operation.java**

    abstract class Operation {

and 1 abstract method:

    public abstract void runOperation();

We use abstract class because we want to prevent the creation of the object for Operation class as we do not need them. We create the abstract method to ensure the implementation of that method in each subclass
### Exception Handling
Exception handling is incorporated to gracefully manage unexpected errors. This ensures the system can recover or gracefully terminate, we implement this to ensure the **file is not found** issue and the **mistype input** issue by using **'try'** and **'catch'**
- **file is not found**: We use the try and catch IOException to check whether the file that we need to open exist.<br/>

      try {
          // Create a FileWriter in append mode by passing true as the second parameter
          FileWriter fileWriter = new FileWriter(filePath, true);
      
          // Wrap the FileWriter in a BufferedWriter for efficient writing
          BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      
          // Append the data to the file
          bufferedWriter.write(WritingContent);
          bufferedWriter.newLine(); // Add a new line for clarity
      
          // Close the BufferedWriter to ensure all data is flushed to the file
          bufferedWriter.close();
      
          finish = true;
      } catch (IOException e) {
          // Handle IO exceptions, e.g., if the file cannot be created or written to
          e.printStackTrace();
      }
  
- **mistype input**: We use try and catch NumberFormatException to check whether the user input the correct type of data format<br/>

      try {
          int tmpID = Integer.parseInt(idField.getText());
          String tmpName = nameField.getText();
          String tmpPhoneNumber = phoneNumberField.getText();
          if (Customer.VerifyCustomerID(tmpID))
          {
              JOptionPane.showMessageDialog(frame, "Customer ID Already Existed");
          }
          else {
              boolean e1 = Employee.addCustomer(tmpID, tmpName, tmpPhoneNumber);
              if (e1){
                  JOptionPane.showMessageDialog(frame, "Customer Added completed.");
              } else{
                  JOptionPane.showMessageDialog(frame, "Error during addition. Please try again.");
              }
          }
      } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(frame, "Wrong input data type. Please try again.");
          idField.setText(""); // Clear the field
          nameField.setText("");
          phoneNumberField.setText("");
      }


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


package Bookstore_Management;

public class Manager extends Employee {
    
    String position, startDate;

    Manager(int employeeID, String name, String emailAddress, String startDate, String position){
        super(employeeID, name, emailAddress, startDate);
        this.position = position;
    }
    
    
}

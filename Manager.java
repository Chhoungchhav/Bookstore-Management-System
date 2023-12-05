package Bookstore_Management;

import java.util.List;

public class Manager extends Employee {
    
    public Manager(int employeeID, String name, String emailAddress, String startDate, double salary){
        super(employeeID, name, emailAddress, startDate, salary);
    }
    public void changeSellerSalary(List<Seller> sellers, double newSalary, int number) {
        if (!sellers.isEmpty()) {
            sellers.get(number-1).setSalary(newSalary);
        }
    }

    
    
}

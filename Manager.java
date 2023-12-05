package Bookstore_Management;

import java.util.List;

public class Manager extends Employee {
    final String position = "manager";
    public Manager(int employeeID, String name, String emailAddress, String startDate){
        super(employeeID, name, emailAddress, startDate);
    }
    public void changeSellerSalary(List<Seller> sellers, double newSalary, int number) {
        if (!sellers.isEmpty()) {
            sellers.get(number-1).setSalary(newSalary);
        }
    }

    @Override
    public String toString() {
        String tmp = super.toString() + this.position;

        return tmp;
    }
    
    
}

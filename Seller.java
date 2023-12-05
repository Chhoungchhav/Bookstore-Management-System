package Bookstore_Management;

public  class Seller extends Employee{

    Seller(int employeeID, String name, String emailAddress, String startDate){
        super(employeeID, name, emailAddress, startDate);
    }
    
    @Override
    public String toString() {
        String tmp = "User is created";

        return tmp;
    }
}

package Bookstore_Management;

public class Customer {
    private int customerID;
    private String name, phoneNumber;
    Customer(int customerID){
        this.customerID = customerID;
    }
    public int getCustomerID(int customerID){
        return customerID;
    }
    public String getCustomerName(int name){
        return name;
    }
}

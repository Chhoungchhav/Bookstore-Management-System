package Bookstore_Management;

public class Customer {
    private int customerID;
    private String Info;
    public Customer(int customerID, String Info){
        this.customerID = customerID;
        this.Info = Info;
    }
    public static int getCustomerID(int customerID){
        return customerID;
    }
}

package Bookstore_Management;

public class Supplier {
    private int supplierID, phoneNumber;
    private String name, genre[];

    Supplier(int supplierID, String name, int phoneNumber){
        this.supplierID = supplierID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

package Bookstore_Management;

public class Supply {
    private int supplyID, bookID, supplierID, employeeID, quantity;
    private String supplyDate;
    private double subTotal, totalPrice;

    Supply(int supplyID, int bookID, int supplierID, int employeeID, int quantity, String supplyDate){
        this.supplyID = supplyID;
        this.bookID = bookID;
        this.supplierID = supplierID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.supplyDate = supplyDate;
    }
    
}

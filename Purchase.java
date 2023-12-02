package Bookstore_Management;

abstract class Purchase {
    private int purchaseID, bookID, customerID, employeeID, quantity;
    private String purchaseDate;
    private double subTotal, totalPrice;

    Purchase(int purchaseID, int bookID, int customerID, int employeeID, int quantity, String purchaseDate){
        this.purchaseID = purchaseID;
        this.bookID = bookID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
    }

    abstract void makePurchase();
}

package Bookstore_Management;

public class Book {
    private int bookID, inStockBook;
    private String title;
    private double salePrice, importPrice;
    private String importDate;
    Book(int bookID, String title, double salePrice, double importPrice, String importDate){
        this.bookID = bookID;
        this.title = title;
        this.salePrice = salePrice;
        this.importPrice = importPrice;
        this.importDate = importDate;
    }
    
    public int getBookID(int bookID) {
        return bookID;
    }
    public double getPrice(int bookID){
        return salePrice;
    }


}

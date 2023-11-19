package Bookstore_Management;

public class Book {
    private int bookID, instockbook;
    private String title;
    private double saleprice, importprice;
    private Date importDate;
    public Book(int bookID, String title, double saleprice, double importprice, int instockbook, Date importDate){
        this.bookID = bookID;
        this.title = title;
        this.saleprice = saleprice;
        this.importDate = importDate;
        this.importprice = importprice;
        this.instockbook = instockbook;
    }
    
    public static int getBookID(int bookID) {
        return bookID;
    }
    public static int getStock(int stock){
        return instockbook;
    }
    public static double getPrice(int price){
        return saleprice;
    }


}

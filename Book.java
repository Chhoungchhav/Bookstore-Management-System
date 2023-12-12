import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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

    public double getSalePrice(int bookID){
        return salePrice;
    }

    public double getImportPrice(int bookID){
        return importPrice;
    }

    public void addBook(int tmpBookID, String tmpTitle, double tmpSalePrice, double tmpImportPrice, String tmpImportDate){
        Scanner sc = new Scanner(System.in);
        String filePath = "Bookstore_Management/BookInfo.txt";

        String WritingContent = tmpBookID + "/" + tmpTitle + "/" + tmpSalePrice +"/" + tmpImportPrice + "/" + tmpImportDate;
        
        Book book1 = new Book(tmpBookID, tmpTitle, tmpSalePrice, tmpImportPrice, tmpImportDate);
        System.out.println(book1);

        try {
            // Create a FileWriter in append mode by passing true as the second parameter
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Wrap the FileWriter in a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Append the data to the file
            bufferedWriter.write(WritingContent);
            bufferedWriter.newLine(); // Add a new line for clarity

            // Close the BufferedWriter to ensure all data is flushed to the file
            bufferedWriter.close();

            System.out.println("Data has been appended to the file successfully.");
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
        }


        sc.close();
    }

    public void checkPopularBook(){

    }
    
    public void checkBookStock(){

    }

}

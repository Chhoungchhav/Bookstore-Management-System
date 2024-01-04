import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

public class Book {
    private int bookID, bookCount;
    private String title;
    private double salePrice, importPrice;
    private String importDate;

    public Book(int bookID, String title, double salePrice, double importPrice, String importDate){
        this.bookID = bookID;
        this.title = title;
        this.salePrice = salePrice;
        this.importPrice = importPrice;
        this.importDate = importDate;
    }

    public Book(int bookID, int bookCount){
        this.bookID = bookID;
        this.bookCount = bookCount;
    }
    
    public int getBookID() {
        return bookID;
    }

    public String getBookTitle(){
        return title;
    }

    public double getSalePrice(){
        return salePrice;
    }

    public double getImportPrice(){
        return importPrice;
    }

    public int getBookCount(){
        return bookCount;
    }

    public void increaseCount(int quantity){
        int count = this.bookCount + quantity;
        this.bookCount = count;
    }

    public static boolean addBook(int tmpBookID, String tmpTitle, double tmpSalePrice, double tmpImportPrice, String tmpImportDate){
        // Scanner sc = new Scanner(System.in);
        String filePath = "Book.txt";

        String WritingContent = tmpBookID + "/" + tmpTitle + "/" + tmpSalePrice +"/" + tmpImportPrice + "/" + tmpImportDate;
        
        Book book1 = new Book(tmpBookID, tmpTitle, tmpSalePrice, tmpImportPrice, tmpImportDate);
        System.out.println(book1);
        boolean added = false;
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

            added = true;
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
        }

        return added;
        // sc.close();
    }

    static ArrayList<Book> bookList = new ArrayList<Book>();

    static ArrayList<Book> bookList1 = new ArrayList<Book>();

    public static void getBookList(){
        String bookPath = "Book.txt";
        try {
                // Create a FileReader
                FileReader fileReader = new FileReader(bookPath);
                // Wrap the FileReader in a BufferedReader for efficient reading
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                // Read each line from the file
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    // Process the line as needed
                    //System.out.println(line);
                    String[] parts = line.split("/");
                    Book tmp = new Book(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), parts[4]);
                    bookList.add(tmp);

                    Book tmp1 = new Book(Integer.parseInt(parts[0]),0);
                    bookList1.add(tmp1);

                }

                // Close the BufferedReader
                bufferedReader.close();
            } catch (IOException e) {
                // Handle IO exceptions, e.g., if the file cannot be read
                e.printStackTrace();
            }
    }
    
    public static boolean VerifyBookID(int id)
    {
       
        getBookList();        

        boolean exist = false;
        for(Book i : bookList)
        {
            // System.out.println(i.getName());
            if(i.getBookID() == id)
            {
                exist = true;
            }
          
        }
        return exist;
    }

    public static boolean VerifyBookID2(int id)
    {
       
        getBookList();        

        boolean exist = false;
        for(Book i : bookList)
        {
        
            if(i.getBookID() == id)
            {
                exist = true;
            }
          
        }

        if(exist==false)
        {
            return true;
        }

        return false;
    }

    public static void countingBook(){
        Seller.getPurchaseList();
        getBookList();
        List<Integer> quantityList = Seller.quantityPurchaseList;
        Iterator<Integer> quantityIterator = quantityList.iterator();
        bookList1.forEach(book->
        Seller.bookPurchaseList.stream()
                .filter(bid -> book.getBookID() == bid)
                .findFirst()
                .ifPresent(bid -> {
                    int quantity = quantityIterator.next();
                    book.increaseCount(quantity);
                })        
            );
    }

    public static String checkPopularBook(){
        getBookList();
        countingBook();
        Book popularBook = bookList1.stream()
            .max(Comparator.comparingInt(Book::getBookCount))
            .orElse(null);
        if(popularBook!=null){
            int popBookID = popularBook.getBookID();
            for(Book i : bookList)
            {
                if(i.getBookID() == popBookID)
                {
                    String s ="Popular Book has book ID: " + popBookID + ", Title: " + i.getBookTitle();
                    return s;
                }
            }
        } 
        return "null";
    }
    @Override
    public String toString() {
        String b = "BookID: "+ this.bookID+", title: " + this.title ;
        return b;
    }


}

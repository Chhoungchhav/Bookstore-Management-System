import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public  class Seller extends Employee{
    final String position = "seller";
    final double salary = 200;
    Seller(int employeeID, String name, String password, String emailAddress, String startDate){
        super(employeeID, name, password, emailAddress, startDate);
    }
    
    @Override
    public double getSalary() {
        return super.getSalary() * this.salary;
    }

    @Override
    public String toString() {
        String tmp = super.toString() + ", position: " + this.position;

        return tmp;
    }

    static ArrayList<Book> bookList = new ArrayList<Book>();

    public static void addPurchase(int tmpPurchaseID,int tmpCustomerID, int tmpBookID, int tmpQuantity, String tmpPurchaseDate){
        String bookPath = "Book.txt";
        double totalPrice = 0;
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
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be read
            e.printStackTrace();
        }

        for(Book i : bookList){
            if (i.getBookID()==tmpBookID){
                totalPrice = i.getSalePrice()*tmpQuantity;
            }
        }
        Scanner sc = new Scanner(System.in);
        String filePath = "Purchase.txt";
        String WritingPurchase = tmpPurchaseDate + "/" + tmpCustomerID + "/" + tmpBookID +"/" + tmpQuantity + "/" + totalPrice + "/"+ tmpPurchaseDate;
        
        try {
            // Create a FileWriter in append mode by passing true as the second parameter
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Wrap the FileWriter in a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Append the data to the file
            bufferedWriter.write(WritingPurchase);
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
    

}

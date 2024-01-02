import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public  class Seller extends Employee{
    final String position = "seller";
    double salary = 200;
    
    public Seller(int employeeID, String name, String password, String emailAddress, String startDate){
        super(employeeID, name, password, emailAddress, startDate);
    }
    
    @Override
    public double getSalary() {
        return super.getSalary() * this.salary;
    }

    

    static ArrayList<Book> bookList = new ArrayList<Book>();
    static ArrayList<Book> bookList1 = new ArrayList<Book>();

    public static Boolean addPurchase(int tmpPurchaseID,int tmpCustomerID, int tmpSellerID, int tmpBookID, int tmpQuantity, String tmpPurchaseDate){
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

                Book tmp1 = new Book(Integer.parseInt(parts[0]),0);
                bookList1.add(tmp1);
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
        String filePath = "Purchase.txt";
        String WritingPurchase = tmpPurchaseID + "/" + tmpCustomerID + "/" + tmpSellerID + "/" + tmpBookID +"/" + tmpQuantity + "/" + totalPrice + "/"+ tmpPurchaseDate;
        boolean added = false;
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
            System.out.println("Purchase: "+tmpPurchaseID+", Customer: "+tmpCustomerID+", BookID: "+tmpBookID+", Quantity: "+ tmpQuantity+ ", TotalePrice: "+totalPrice+", Date: "+tmpPurchaseDate);
            added = true;
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
        }
        return added;
    }
    
    static ArrayList<Integer> purchaseList = new ArrayList<Integer>();
    static ArrayList<Integer> bookPurchaseList = new ArrayList<Integer>();
    static ArrayList<Integer> customerPurchaseList = new ArrayList<Integer>();
    static ArrayList<Integer> quantityPurchaseList = new ArrayList<Integer>();
    public static void getPurchaseList(){
        String purchasePath = "Purchase.txt";
        try {
                // Create a FileReader
                FileReader fileReader = new FileReader(purchasePath);
                // Wrap the FileReader in a BufferedReader for efficient reading
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                // Read each line from the file
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    // Process the line as needed
                    //System.out.println(line);
                    String[] parts = line.split("/");
                    purchaseList.add(Integer.parseInt(parts[0]));
                    customerPurchaseList.add(Integer.parseInt(parts[1]));
                    bookPurchaseList.add(Integer.parseInt(parts[2]));
                    quantityPurchaseList.add(Integer.parseInt(parts[4]));
                }

                // Close the BufferedReader
                bufferedReader.close();
            } catch (IOException e) {
                // Handle IO exceptions, e.g., if the file cannot be read
                e.printStackTrace();
            }
    }
    
    public static boolean VerifyPurchaseID(int id)
    {
       
        getPurchaseList();        

        boolean exist = false;
        for(int i : purchaseList)
        {
            // System.out.println(i.getName());
            if(i == id)
            {
                exist = true;
            }
          
        }

        if(exist==true)
        {
            System.out.println("PurchaseID already exist");
            return true;
        }

        return false;
    }
    
    
    @Override
        public String toString() {
            String tmp = super.toString() + ", position: " + this.position;

            return tmp;
        }
}

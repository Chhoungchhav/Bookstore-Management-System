import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private int customerID, count;
    Customer(int customerID){
        this.customerID = customerID;
    }
    Customer(int customerID, int count){
        this.customerID = customerID;
        this.count = count;
    }
    public int getCustomerID(){
        return customerID;
    }
    public int getCustomerCount(){
        return count;
    }
    public void increaseCount(){
        this.count++;
    }
    

    static ArrayList<Integer> customerList = new ArrayList<Integer>();
    static ArrayList<Customer> customerList1 = new ArrayList<Customer>();
    public static void getCustomerList(){
        String customerPath = "Customer.txt";
        try {
                // Create a FileReader
                FileReader fileReader = new FileReader(customerPath);
                // Wrap the FileReader in a BufferedReader for efficient reading
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                // Read each line from the file
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    // Process the line as needed
                    //System.out.println(line);
                    String[] parts = line.split("/");
                    customerList.add(Integer.parseInt(parts[0]));
                    Customer tmp1 = new Customer(Integer.parseInt(parts[0]),0);
                    customerList1.add(tmp1);
                }

                // Close the BufferedReader
                bufferedReader.close();
            } catch (IOException e) {
                // Handle IO exceptions, e.g., if the file cannot be read
                e.printStackTrace();
            }
    }

    public static boolean VerifyCustomerID(int id)
    {
       
        getCustomerList();        

        boolean exist = false;
        for(int i : customerList)
        {
            // System.out.println(i.getName());
            if(i== id)
            {
                exist = true;
            }
          
        }
        return exist;
    }
    
    public static boolean VerifyCustomerID2(int id)
    {
       
        getCustomerList();        

        boolean exist = false;
        for(int i : customerList)
        {
            // System.out.println(i.getName());
            if(i== id)
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
        getCustomerList();
        customerList1.forEach(customer ->
            Seller.customerPurchaseList.stream()
                    .filter(cid -> customer.getCustomerID() == cid)
                    .forEach(cid -> customer.increaseCount())
        );
    }
    public static int checkRegularCustomer(){
        getCustomerList();
        countingBook();
      
        Customer regularCustomer = customerList1.stream()
            .max(Comparator.comparingInt(Customer::getCustomerCount))
            .orElse(null);

        if (regularCustomer != null) {
            int regID = regularCustomer.getCustomerID();
            return regID;
        } else {
            return 0;
        }
    }
    @Override
    public String toString() {
        String s = "CustomerID: "+ this.customerID ;
        return s;
    }

    
}

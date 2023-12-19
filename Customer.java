import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Customer {
    private int customerID;
    private String name, phoneNumber;
    Customer(int customerID){
        this.customerID = customerID;
    }
    public int getCustomerID(){
        return customerID;
    }
    public String getCustomerName(){
        return name;
    }
    public String getCustomerPhone(){
        return phoneNumber;
    }
    public void checkRegularCustomer(){

    }

    static ArrayList<Integer> customerList = new ArrayList<Integer>();

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

        if(exist==false)
        {
            System.out.println("CustomerID doesn't exist");
            return true;
        }

        return false;
    }
}

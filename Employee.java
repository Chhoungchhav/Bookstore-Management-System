import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;

public class Employee {
    private int employeeID, startYear, workYear, currentYear;
    private String name, emailAddress, password, startDate, year;

    

    public Employee(int employeeID, String name, String password, String emailAddress, String startDate){
        this.employeeID = employeeID;
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
        this.startDate = startDate;

        this.currentYear = Year.now().getValue();
        
        String dateParts[] = this.startDate.split("-");
        year = dateParts[2];

        startYear = Integer.parseInt(year);

        this.workYear = currentYear - startYear;
    }

    public Employee(int employeeID, String password){
        this.employeeID = employeeID;
        this.password = password;
    }

    public double getSalary(){
        if (workYear >= 10){
            return 1.75;
        }

        else if (workYear >= 5){
            return 1.5;
        }

        else if (workYear >= 3){
            return 1.25;
        }

        else {
            return 1;
        }
    }

    public int getEmployeeID(){
        return employeeID;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return emailAddress;
    }

    public String getStartDate(){
        return startDate;
    }

    
    @Override
    public String toString() {
        String s = "EmployeeID: "+ this.employeeID+", name: " + this.name ;
        return s;
    }



    @Override
    public boolean equals(Object obj) {
        Employee e1 = (Employee) obj;
       
        if( this.employeeID == e1.employeeID && this.password.equals(e1.password) )
        {
            return true;
        }
        return false;
    }

    public static void addCustomer(int tmpCutomerID, String name, String phoneNumber){
        String customerPath = "Customer.txt";

        String WritingCustomer = tmpCutomerID +"/"+name+ "/" + phoneNumber;
        
        Customer customer1 = new Customer(tmpCutomerID);
        System.out.println(customer1);

        try {
            // Create a FileWriter in append mode by passing true as the second parameter
            FileWriter fileWriter = new FileWriter(customerPath, true);

            // Wrap the FileWriter in a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Append the data to the file
            bufferedWriter.write(WritingCustomer);
            bufferedWriter.newLine(); // Add a new line for clarity

            // Close the BufferedWriter to ensure all data is flushed to the file
            bufferedWriter.close();

            System.out.println("Data has been appended to the file successfully.");
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
        }
    }
}

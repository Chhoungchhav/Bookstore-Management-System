import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogIn {

    static ArrayList<Employee> employeeList = new ArrayList<Employee>(); 

    static ArrayList<String> positionList = new ArrayList<String>();
    
    public static void getEmployeeList()
    {
        String filePath = "Bookstore_Management/EmployeeInfo.txt";
        
        try {
            // Create a FileReader
            FileReader fileReader = new FileReader(filePath);
            // Wrap the FileReader in a BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Read each line from the file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Process the line as needed
                //System.out.println(line);
                String[] parts = line.split("/");
                Employee tmp = new Employee(Integer.parseInt(parts[0]), parts[2]);
                employeeList.add(tmp);
                positionList.add(parts[5]);
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be read
            e.printStackTrace();
        }
    }
    
    public static boolean VerifyEmployeeID(int id)
    {
       
        getEmployeeList();        

        boolean exist = false;
        for(Employee i : employeeList)
        {
            // System.out.println(i.getName());
            if(i.getEmployeeID() == id)
            {
                exist = true;
            }
          
        }

        if(exist==true)
        {
            System.out.println("Employee ID exist");
            return true;
        }

        return false;
    }

    public static void loginUser(Employee loginUser){
        
        getEmployeeList();   

        boolean exist = false;
        for(Employee i : employeeList)
        {
            if(i.equals(loginUser))
            {
                exist = true;
            }
          
        }

        if(exist==true)
        {
            System.out.println("Log in successful");
        }else
        {
            System.out.println("Incorrect username or password");
        }
    }

    
    public static String getPosition(Employee loginUser) {
        getEmployeeList();
    
        String position = null; // Initialize with a default value
    
        int index = employeeList.indexOf(loginUser);
    
        if (index != -1) {
            position = positionList.get(index);
        }
    
        return position; // Returns null if no matching user is found
    }
    

}

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogIn {

    static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    
    static ArrayList<Manager> mList = new ArrayList<Manager>();

    static ArrayList<Seller> sList = new ArrayList<Seller>();
    
    public static void getEmployeeList()
    {
        String filePath = "EmployeeInfo.txt";
        
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
                
                if(parts[5].equals("manager")) {
                    Employee tmp2 = new Manager(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4]);
                    mList.add((Manager)tmp2);
                }
                else if(parts[5].equals("seller")) {
                    Employee tmp2 = new Seller(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4]);
                    sList.add((Seller)tmp2);
                }
                employeeList.add(tmp);
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
            return true;
        }

        return false;
    }

    public static boolean loginUser(Employee loginUser){
        
        getEmployeeList();   

        boolean exist = false;
        for(Employee i : employeeList)
        {
            if(i.equals(loginUser))
            {
                exist = true;
            }
          
        }

        return exist;
    }
    
    public static Manager getManager(Employee loginUser){
        getEmployeeList();

        Manager m1 = null;

        for (Manager i : mList) {
            if (i.equals(loginUser)) {
                m1 = i;
                break; // Break out of the loop once a matching user is found
            }
        }
    
        return m1;
    }

    public static Seller getSeller(Employee loginUser) {
        getEmployeeList();
    
        Seller s1 = null;
    
        for (Seller i : sList) {
            if (i.equals(loginUser)) {
                s1 = i;
                break; // Break out of the loop once a matching user is found
            }
        }

        return s1; 
    }
    
    


    

}

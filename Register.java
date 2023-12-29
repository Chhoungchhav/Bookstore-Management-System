import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {

    public static boolean registerEmployee(int tmpID, String tmpName, String tmpPassword, String tmpEmail, String tmpStartDate, String tmpPosition){
        Scanner sc = new Scanner(System.in);
        String filePath = "EmployeeInfo.txt";

        String WritingContent = tmpID + "/" + tmpName + "/" + tmpPassword +"/" + tmpEmail + "/" + tmpStartDate + "/" + tmpPosition;
        
        Employee employee1 = new Employee(tmpID, tmpName, tmpPassword, tmpEmail, tmpStartDate);
        System.out.println(employee1);

        boolean finish = false;

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

            finish = true;
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
        }


        sc.close();

        return finish;
    }

}

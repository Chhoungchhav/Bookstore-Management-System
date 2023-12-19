
import java.util.Scanner;

public class start {
    public static void main(String[] args) {
        String position = null;
        Employee e1 = null;
        Scanner scanner = new Scanner(System.in);
        
        Authenticate authManager = new Authenticate(scanner);
        authManager.runAuthenticationSystem();

        position = authManager.getUserPosition();
        e1 = authManager.getEmployee();

        if (position != null && e1 != null){
            if (position.equals("manager")){
                OperationManager operation1 = new OperationManager(scanner, e1);
                operation1.runOperation();
            }
            else if (position.equals("seller")){
                OperationSeller operation1 = new OperationSeller(scanner, e1);
                operation1.runOperation();
            }
        }
        scanner.close();
    }
}

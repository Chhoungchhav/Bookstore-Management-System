
import java.util.Scanner;

public class start {
    public static void main(String[] args) {
        Manager m1 = null;
        Seller s1 = null;
        Scanner scanner = new Scanner(System.in);
        
        Authenticate authManager = new Authenticate();
        authManager.runAuthenticationSystem();
        
        m1 = authManager.getManager();
        s1 = authManager.getSeller();
        
        if (m1 != null){
            OperationManager operation1 = new OperationManager(scanner, m1);
            operation1.runOperation();
        }
        else if (s1 != null){
            OperationSeller operation2 = new OperationSeller(scanner, s1);
            operation2.runOperation();
        }

        scanner.close();
    }
}

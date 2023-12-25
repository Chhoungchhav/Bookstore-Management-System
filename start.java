
import java.util.Scanner;

public class start {
    public static void main(String[] args) {
        String position = null;
        Manager m1 = null;
        Seller s1 = null;
        Scanner scanner = new Scanner(System.in);
        
        Authenticate authManager = new Authenticate(scanner);
        authManager.runAuthenticationSystem();

        position = authManager.getUserPosition();

        if (position != null){
            if (position.equals("manager")){
                m1 = authManager.getManager();
                OperationManager operation1 = new OperationManager(scanner, m1);
                operation1.runOperation();
            }
            else if (position.equals("seller")){
                s1 = authManager.getSeller();
                OperationSeller operation1 = new OperationSeller(scanner, s1);
                operation1.runOperation();
            }
        }
        scanner.close();
    }
}

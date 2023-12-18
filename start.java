
import java.util.Scanner;

public class start {
    public static void main(String[] args) {
        String position = null;
        Scanner scanner = new Scanner(System.in);
        Authenticate authManager = new Authenticate(scanner);
        authManager.runAuthenticationSystem();
        position = authManager.getUserPosition();
        if (position != null){
            Operation operation1 = new Operation(scanner, position);
            operation1.runOperation();
        }
        scanner.close();
    }
}

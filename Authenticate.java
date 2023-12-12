

import java.util.Scanner;

public class Authenticate {
    
    private Scanner sc;

    public Authenticate(Scanner scanner) {
        this.sc = scanner;
    }

    public void runAuthenticationSystem() {
        int choice;

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("other. Quit");
        choice = sc.nextInt();
        String tmp = sc.nextLine();

        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            default:
                break;
        }
    }

    private void registerUser() {
        String tmpPassword;
        String tmpPosition;
        int tmpID;
        String tmpName, tmpEmail, tmpStartDate;

        do {
            System.out.print("Input employee ID: ");
            tmpID = sc.nextInt();
        } while (LogIn.VerifyEmployeeID(tmpID));
        sc.nextLine();

        System.out.print("Input name: ");
        tmpName = sc.nextLine();

        System.out.print("Input password: ");
        tmpPassword = sc.nextLine();

        System.out.print("Input position: ");
        tmpPosition = sc.nextLine();
        System.out.print("Input email address: ");
        tmpEmail = sc.nextLine();
        System.out.print("Input start date (DD-MM-YYYY): ");
        tmpStartDate = sc.nextLine();

        Register.registerEmployee(tmpID, tmpName, tmpPassword, tmpEmail, tmpStartDate, tmpPosition);
    }

    private void loginUser() {
        int tmpID;
        String tmpPassword;

        System.out.print("Input employee ID: ");
        tmpID = sc.nextInt();
        sc.nextLine();
        System.out.print("Input password: ");
        tmpPassword = sc.nextLine();
        Employee tmpuser = new Employee(tmpID, tmpPassword);
        LogIn.loginUser(tmpuser);
    }
}

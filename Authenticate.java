// package Bookstore_Management;

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
            System.out.println("Input employee ID: ");
            tmpID = sc.nextInt();
        } while (LogIn.VerifyEmployeeID(tmpID));
        sc.nextLine();

        System.out.println("Input name: ");
        tmpName = sc.nextLine();

        System.out.println("Input password: ");
        tmpPassword = sc.nextLine();

        System.out.println("Input position: ");
        tmpPosition = sc.nextLine();
        System.out.println("Input email address: ");
        tmpEmail = sc.nextLine();
        System.out.println("Input start date (DD-MM-YYYY): ");
        tmpStartDate = sc.nextLine();


        if (tmpPosition.equals("manager")){
            Register.registerManager(tmpID, tmpName, tmpPassword, tmpEmail, tmpStartDate);
        }
        else if (tmpPosition.equals("seller")){
            Register.registerSeller(tmpID, tmpName, tmpPassword, tmpEmail, tmpStartDate);
        }
    }

    private void loginUser() {
        int tmpID;
        String tmpPassword;

        System.out.println("Input employee ID: ");
        tmpID = sc.nextInt();
        sc.nextLine();
        System.out.println("Input password: ");
        tmpPassword = sc.nextLine();
        Employee tmpuser = new Employee(tmpID, tmpPassword);
        LogIn.loginUser(tmpuser);
    }
}

package Bookstore_Management;

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
        String tmpUserName;
        String tmpPassword;
        String tmpPosition;
        int tmpID;
        String tmpName, tmpEmail, tmpStartDate;

        do {
            System.out.println("Input username: ");
            tmpUserName = sc.nextLine();
        } while (LogIn.VerifyUserName(tmpUserName));

        System.out.println("Input password: ");
        tmpPassword = sc.nextLine();
        System.out.println("Input position: ");
        tmpPosition = sc.nextLine();

        

        System.out.println("Input employee ID: ");
        tmpID = sc.nextInt();
        sc.nextLine();
        System.out.println("Input email address: ");
        tmpEmail = sc.nextLine();
        System.out.println("Input start date (DD-MM-YYYY): ");
        tmpStartDate = sc.nextLine();

        Register.registerUser(tmpUserName, tmpPassword, tmpPosition);

        if (tmpPosition.equals("manager")){
            Register.registerManager(tmpID, tmpUserName, tmpEmail, tmpStartDate);
        }
        else if (tmpPosition.equals("seller")){
            Register.registerSeller(tmpID, tmpUserName, tmpEmail, tmpStartDate);
        }
    }

    private void loginUser() {
        String tmpName;
        String tmpPassword;
        String position;

        System.out.println("Input name: ");
        tmpName = sc.nextLine();
        System.out.println("Input password: ");
        tmpPassword = sc.nextLine();
        User tmpuser = new User(tmpName, tmpPassword);
        LogIn.loginUser(tmpuser);
        position = LogIn.getPosition(tmpuser);
        System.out.println(position);
    }
}

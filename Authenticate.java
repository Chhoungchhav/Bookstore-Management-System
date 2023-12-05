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
        String tmpName;
        String tmpPassword;
        String position;

        do {
            System.out.println("Input name: ");
            tmpName = sc.nextLine();
        } while (LogIn.VerifyUserName(tmpName));

        System.out.println("Input password: ");
        tmpPassword = sc.nextLine();
        System.out.println("Input position: ");
        position = sc.nextLine();
        Register.registerUser(tmpName, tmpPassword, position);
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

package Bookstore_Management;

import java.util.Scanner;

public class start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Authenticate authManager = new Authenticate(scanner);
        authManager.runAuthenticationSystem();
        scanner.close();
    }
}

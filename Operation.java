import java.util.Scanner;

public class Operation {

    private Scanner sc;

    private String position;

    public Operation(Scanner scanner, String position){
        this.sc = scanner;
        this.position = position;
    }

    public void runOperation() {

        int choice;

        if (this.position.equals("seller")){
            System.out.println("\nWelcome, Seller! \n");
            System.out.println("1. Add book");
            System.out.println("2. Add purchase");
            System.out.println("3. Add customer");
            System.out.println("4. Check Salary");
            System.out.println("other. Quit");
            choice = sc.nextInt();
            String tmp = sc.nextLine();

            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    ;
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    ;
                    break;
                default:
                    break;
            }
        }

        else if (this.position.equals("manager")){
            System.out.println("\nWelcome, Manager! \n");
            System.out.println("1. Add customer");
            System.out.println("2. Check popular book");
            System.out.println("3. Check regular customer");
            System.out.println("4. Change salary");
            System.out.println("5. Check Salary");
            System.out.println("other. Quit");
            choice = sc.nextInt();
            String tmp = sc.nextLine();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    ;
                    break;
                default:
                    break;
            }
        }
        
    }

    private void addCustomer(){
        int tmpID;
        String tmpName, tmpPhone;

        System.out.print("Input customer ID: ");
        tmpID = sc.nextInt();
        sc.nextLine();

        System.out.print("Input name: ");
        tmpName = sc.nextLine();

        System.out.print("Input phone number: ");
        tmpPhone = sc.nextLine();

        Employee.addCustomer(tmpID, tmpName, tmpPhone);
    }

}

import java.util.Scanner;

public class OperationManager extends Operation{

    private Scanner sc;
    
    public OperationManager(Scanner scanner,Employee employee){
        super(scanner);
    }

    @Override
    public void runOperation(){
        int choice;

        System.out.println("\nWelcome, " + "\n");
        System.out.println("1. Add customer");
        System.out.println("2. Check popular book");
        System.out.println("3. Check regular customer");
        System.out.println("4. Change salary");
        System.out.println("5. Check Salary");
        System.out.println("other. Quit");
        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                super.addCustomer();
                break;
            case 2:
                ;
                break;
            case 3:
                ;
                break;
            case 4:
                ;
                break;
            case 5:
                ;
                break;
            default:
                break;
        }
    }

}

import java.util.Scanner;

public class OperationManager extends Operation{

    private Scanner sc;

    private Manager m1;
    
    public OperationManager(Scanner scanner, Manager manager){
        super(scanner);
        this.sc = scanner;
        this.m1 = manager;
    }

    @Override
    public void runOperation(){
        int choice;

        System.out.println("\nWelcome, " + m1.getName() + "\n");
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
                checkPopularBook();
                break;
            case 3:
                Customer.checkRegularCustomer();
                break;
            case 4:
                ;
                break;
            case 5:
                System.out.println(m1.getSalary());;
                break;
            default:
                break;
        }
    }

    private void checkPopularBook(){

    }

}

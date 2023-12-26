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
        int choice, choice1 = 0;

        System.out.println("\nWelcome, " + m1.getName() + "\n");
        do
        {
        System.out.println("1. Add customer");
        System.out.println("2. Check popular book");
        System.out.println("3. Check regular customer");
        System.out.println("4. Change salary");
        System.out.println("5. Check Salary");
        System.out.println("6. Quit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        sc.nextLine();
        
        switch (choice) {
            case 1:
                super.addCustomer();
                break;
            case 2:
                Book.checkPopularBook();
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
        }

        if (choice <= 5){
            System.out.println("\nDo you want to continue the operation?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");
            choice1 = sc.nextInt();
            sc.nextLine();
            System.out.println();
        }

        }while(choice<=5 && choice1 == 1);
    }

}

import java.util.Scanner;

abstract class Operation {

    private Scanner sc;

    public Operation(Scanner scanner){
        this.sc = scanner;
    }

    public abstract void runOperation();

    protected void addCustomer(){
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

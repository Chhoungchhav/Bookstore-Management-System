import java.util.Scanner;

public class OperationSeller extends Operation{

    private Scanner sc;

    private Seller s1;

    public OperationSeller(Scanner scanner, Seller seller){
        super(scanner);
        this.sc= scanner;
        this.s1 = seller;
    }

    @Override
    public void runOperation(){
        int choice, choice1 = 0;

        System.out.println("\nWelcome, " + s1.getName() + "\n");
        do{
        System.out.println("1. Add book");
        System.out.println("2. Add purchase");
        System.out.println("3. Add customer");
        System.out.println("4. Check Salary");
        System.out.println("5. Quit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        sc.nextLine();
        
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                addPurchase();
                break;
            case 3:
                addCustomer();
                break;
            case 4:
                System.out.println(s1.getSalary());;
                break;
            default:
                break;
        }

        if (choice < 5){
            System.out.println("\nDo you want to continue the operation?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");
            choice1 = sc.nextInt();
            sc.nextLine();
            System.out.println();
        }

        }while(choice < 5 && choice1==1);
    }

    private void addBook(){
        int tempBookID;
        double tempSalePrice, tempImportPrice;
        String tempTitle, tempImportDate;
        do {
            System.out.print("Input BookID: ");
            tempBookID = sc.nextInt();
        } while (Book.VerifyBookID(tempBookID));
        sc.nextLine();

        System.out.print("Input title: ");
        tempTitle = sc.nextLine();

        System.out.print("Input sale price: ");
        tempSalePrice = sc.nextDouble();
        sc.nextLine();

        System.out.print("Input import price: ");
        tempImportPrice = sc.nextDouble();
        sc.nextLine();

        System.out.print("Input import date(DD-MM-YYYY): ");
        tempImportDate = sc.nextLine();
        Book.addBook(tempBookID, tempTitle, tempSalePrice, tempImportPrice, tempImportDate);
    }

    private void addPurchase(){
        int tempPurchaseID, tempQuantity, tempCustomerID, tempBookID;
        String tempPurchaseDate;

        do{
            System.out.print("Input PurchaseID: ");
            tempPurchaseID = sc.nextInt();
        } while(Seller.VerifyPurchaseID(tempPurchaseID));
        sc.nextLine();

        do{
            System.out.print("Input CustomerID: ");
            tempCustomerID = sc.nextInt();
        } while(Customer.VerifyCustomerID(tempCustomerID));
        sc.nextLine();

        do {
            System.out.print("Input BookID: ");
            tempBookID = sc.nextInt();
        } while (Book.VerifyBookID2(tempBookID));
        sc.nextLine();

        System.out.print("Input product quantity: ");
        tempQuantity = sc.nextInt();
        sc.nextLine();

        System.out.print("Input purchase date(DD-MM-YYYY): ");
        tempPurchaseDate = sc.nextLine();

        s1.addPurchase(tempPurchaseID, tempCustomerID, s1.getEmployeeID(), tempBookID, tempQuantity, tempPurchaseDate);
    }
}

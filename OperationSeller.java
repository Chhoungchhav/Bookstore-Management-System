import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationSeller extends Operation{

    private Scanner sc;

    private Seller s1;

    public OperationSeller(Scanner scanner, Seller seller){
        super(scanner);
        this.sc= scanner;
        this.s1 = seller;
    }

    @Override
    public void runOperation() {
        frame = new JFrame("Seller Operation");

        JPanel panel1 = sellerPanel();
        JPanel panel2 = addBook();
        JPanel panel3 = addPurchase();
        JPanel panel4 = super.addCustomer();
        JPanel panel5 = checkSalary();

        frame.setLayout(new CardLayout());
        frame.add(panel1, "main");
        frame.add(panel2, "addBook");
        frame.add(panel3, "addPurchase");
        frame.add(panel4, "addCustomer");
        frame.add(panel5, "checkSalary");

        // Setting frame properties
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        waitForGUIClose();
    }

    private void waitForGUIClose() {
        // Wait for the frame to be closed
        while (frame.isVisible()) {
            try {
                Thread.sleep(100); // Sleep for a short duration
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static JPanel sellerPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton addBookButton = new JButton("Add Book");
        JButton addPurchaseButton = new JButton("Add Purchase");
        JButton addCustomerButton = new JButton("Add Customer");
        JButton checkSalaryButton = new JButton("Check Salary");
        JButton quitButton = new JButton("Quit");


        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "addBook");
            }
        });

        addPurchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "addPurchase");
            }
        });

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "addCustomer");
            }
        });

        checkSalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "checkSalary");
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        panel.add(addBookButton);
        panel.add(addPurchaseButton);
        panel.add(addCustomerButton);
        panel.add(checkSalaryButton);
        panel.add(quitButton);

        return panel;
    }

    private JPanel addBook() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel idLabel = new JLabel("Book ID:");
        JTextField idField = new JTextField();
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();
        JLabel spriceLabel = new JLabel("Sale Price:");
        JTextField spriceField = new JTextField();
        JLabel ipriceLabel = new JLabel("Import Price:");
        JTextField ipriceField = new JTextField();
        JLabel importDateLabel = new JLabel("Import Date(DD-MM-YYYY):");
        JTextField importDateField = new JTextField();
        JButton backButton = new JButton("Back");
        JButton addButtonPanel = new JButton("Add");

        addButtonPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tmpID = Integer.parseInt(idField.getText());
                    String tmpTitle = titleField.getText();
                    double tmpSalePrice = Double.parseDouble(spriceField.getText());
                    double tmpImportPrice = Double.parseDouble(ipriceField.getText());
                    String tmpImportDate = importDateField.getText();
                    if (Book.VerifyBookID(tmpID))
                    {
                        JOptionPane.showMessageDialog(frame, "Book Already Existed");
                    }
                    else {
                        boolean book1 = Book.addBook(tmpID, tmpTitle, tmpSalePrice, tmpImportPrice, tmpImportDate);
                        if (book1){
                            JOptionPane.showMessageDialog(frame, "Book added.");
                        } else{
                            JOptionPane.showMessageDialog(frame, "Error during addition. Please try again.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Wrong input data type. Please try again.");
                    idField.setText(""); // Clear the field
                    titleField.setText("");
                    spriceField.setText("");
                    ipriceField.setText("");
                    importDateField.setText("");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "main");
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(spriceLabel);
        panel.add(spriceField);
        panel.add(ipriceLabel);
        panel.add(ipriceField);
        panel.add(importDateLabel);
        panel.add(importDateField);
        panel.add(backButton);
        panel.add(addButtonPanel);

        return panel;
    }

    private JPanel addPurchase() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel purchaseIDLabel = new JLabel("Purchase ID:");
        JTextField purchaseIDField = new JTextField();
        JLabel cIDLabel = new JLabel("Customer ID:");
        JTextField cIDField = new JTextField();
        JLabel bookIDLabel = new JLabel("Book ID:");
        JTextField bookIDField = new JTextField();
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField();
        JLabel purchaseDateLabel = new JLabel("Purchase Date(DD-MM-YYYY):");
        JTextField purchaseDateField = new JTextField();
        JButton backButton = new JButton("Back");
        JButton addButtonPanel = new JButton("Add");

        addButtonPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tmpID = Integer.parseInt(purchaseIDField.getText());
                    int tmpcID = Integer.parseInt(cIDField.getText());
                    int tmpeID = s1.getEmployeeID();
                    int tmpBookID = Integer.parseInt(bookIDField.getText());
                    int tmpQuantity = Integer.parseInt(quantityField.getText());
                    String tmpPurchaseDate = purchaseDateField.getText();
                    if (Seller.VerifyPurchaseID(tmpID)){
                        JOptionPane.showMessageDialog(frame, "Purchase already exist.");
                    }
                    else{
                        if (Book.VerifyBookID2(tmpBookID)){
                                JOptionPane.showMessageDialog(frame, "Book not exist.");
                        }
                        else{
                            if(Customer.VerifyCustomerID2(tmpcID)){
                                JOptionPane.showMessageDialog(frame, "Customer not exist.");
                            }
                            else{
                                boolean purchase1 = Seller.addPurchase(tmpID, tmpcID, tmpeID, tmpBookID, tmpQuantity, tmpPurchaseDate);
                                if (purchase1){
                                    JOptionPane.showMessageDialog(frame, "Purchase added.");
                                } else{
                                    JOptionPane.showMessageDialog(frame, "Error during addition. Please try again.");
                                }
                            }
                        }
                    }
                        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Wrong input data type. Please try again.");
                    purchaseIDField.setText(""); // Clear the field
                    cIDField.setText("");
                    bookIDField.setText("");
                    quantityField.setText("");
                    purchaseDateField.setText("");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "main");
            }
        });

        panel.add(purchaseIDLabel);
        panel.add(purchaseIDField);
        panel.add(cIDLabel);
        panel.add(cIDField);
        panel.add(bookIDLabel);
        panel.add(bookIDField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(purchaseDateLabel);
        panel.add(purchaseDateField);
        panel.add(backButton);
        panel.add(addButtonPanel);

        return panel;
    }

    private JPanel checkSalary() {

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Your Salary is " + s1.getSalary());
        panel.setLayout(new GridLayout(0, 2));
        JButton backButton = new JButton("Back");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "main");
            }
        });

        panel.add(label);
        panel.add(backButton);
        
        return panel;
    }

//     @Override
//     public void runOperation(){
//         try{
//         int choice, choice1 = 0;

//         System.out.println("\nWelcome, " + s1.getName() + "\n");
//         do{
//         System.out.println("1. Add book");
//         System.out.println("2. Add purchase");
//         System.out.println("3. Add customer");
//         System.out.println("4. Check Salary");
//         System.out.println("5. Quit");
//         System.out.print("Enter your choice: ");
//         choice = sc.nextInt();
//         sc.nextLine();
        
//         switch (choice) {
//             case 1:
//                 addBook();
//                 break;
//             case 2:
//                 addPurchase();
//                 break;
//             case 3:
//                 addCustomer();
//                 break;
//             case 4:
//                 System.out.println(s1.getSalary());;
//                 break;
//             default:
//                 break;
//         }

//         if (choice < 5){
//             System.out.println("\nDo you want to continue the operation?");
//             System.out.println("1. Yes");
//             System.out.println("2. No");
//             System.out.print("Enter your choice: ");
//             choice1 = sc.nextInt();
//             sc.nextLine();
//             System.out.println();
//         }

//         }while(choice < 5 && choice1==1);
//         }catch (java.util.InputMismatchException e){
//             System.out.println("Please input correct data type");
//         }
//     }

//     private void addBook(){
//         int tempBookID;
//         double tempSalePrice, tempImportPrice;
//         String tempTitle, tempImportDate;
//         do {
//             System.out.print("Input BookID: ");
//             tempBookID = sc.nextInt();
//         } while (Book.VerifyBookID(tempBookID));
//         sc.nextLine();

//         System.out.print("Input title: ");
//         tempTitle = sc.nextLine();

//         System.out.print("Input sale price: ");
//         tempSalePrice = sc.nextDouble();
//         sc.nextLine();

//         System.out.print("Input import price: ");
//         tempImportPrice = sc.nextDouble();
//         sc.nextLine();

//         System.out.print("Input import date(DD-MM-YYYY): ");
//         tempImportDate = sc.nextLine();
//         Book.addBook(tempBookID, tempTitle, tempSalePrice, tempImportPrice, tempImportDate);
//     }

//     private void addPurchase(){
//         int tempPurchaseID, tempQuantity, tempCustomerID, tempBookID;
//         String tempPurchaseDate;

//         do{
//             System.out.print("Input PurchaseID: ");
//             tempPurchaseID = sc.nextInt();
//         } while(Seller.VerifyPurchaseID(tempPurchaseID));
//         sc.nextLine();

//         do{
//             System.out.print("Input CustomerID: ");
//             tempCustomerID = sc.nextInt();
//         } while(Customer.VerifyCustomerID(tempCustomerID));
//         sc.nextLine();

//         do {
//             System.out.print("Input BookID: ");
//             tempBookID = sc.nextInt();
//         } while (Book.VerifyBookID2(tempBookID));
//         sc.nextLine();

//         System.out.print("Input product quantity: ");
//         tempQuantity = sc.nextInt();
//         sc.nextLine();

//         System.out.print("Input purchase date(DD-MM-YYYY): ");
//         tempPurchaseDate = sc.nextLine();

//         s1.addPurchase(tempPurchaseID, tempCustomerID, s1.getEmployeeID(), tempBookID, tempQuantity, tempPurchaseDate);
//     }
}

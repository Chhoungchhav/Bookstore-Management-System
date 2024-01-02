import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Operation {

    private Scanner sc;
    private static JFrame frame;

    public Operation(Scanner scanner){
        this.sc = scanner;
    }

    public abstract void runOperation();

    protected JPanel addCustomer() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel idLabel = new JLabel("Customer ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JTextField phoneNumberField = new JTextField();
        JButton backButton = new JButton("Back");
        JButton AddButtonPanel3 = new JButton("Add");

        AddButtonPanel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tmpID = Integer.parseInt(idField.getText());
                    String tmpName = nameField.getText();
                    String tmpPhoneNumber = phoneNumberField.getText();
                    boolean e1 = Employee.addCustomer(tmpID, tmpName, tmpPhoneNumber);
                    if (e1){
                        JOptionPane.showMessageDialog(frame, "User registration completed.");
                    } else{
                        JOptionPane.showMessageDialog(frame, "Error during registration. Please try again.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Wrong input data type. Please try again.");
                    idField.setText(""); // Clear the field
                    nameField.setText("");
                    phoneNumberField.setText("");
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
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);
        panel.add(backButton);
        panel.add(AddButtonPanel3);

        return panel;
    }

    // protected void addCustomer(){
    //     int tmpID;
    //     String tmpName, tmpPhone;

    //     System.out.print("Input customer ID: ");
    //     tmpID = sc.nextInt();
    //     sc.nextLine();

    //     System.out.print("Input name: ");
    //     tmpName = sc.nextLine();

    //     System.out.print("Input phone number: ");
    //     tmpPhone = sc.nextLine();

    //     Employee.addCustomer(tmpID, tmpName, tmpPhone);
    // }
    

}

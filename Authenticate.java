import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Authenticate {

    private Manager manager = null;

    private Seller seller = null;

    private static JFrame frame;

    public Authenticate() {
    }

    public void runAuthenticationSystem() {
        frame = new JFrame("Authentication");

        JPanel panel1 = mainPanel();
        JPanel panel2 = loginUser();
        JPanel panel3 = registerUser();

        frame.setLayout(new CardLayout());
        frame.add(panel1, "main");
        frame.add(panel2, "login");
        frame.add(panel3, "register");

        // Setting frame properties
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        waitForGUIClose();

        // Assign values after the GUI is closed
        this.manager= getManager();
        this.seller = getSeller();

        
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

    public Manager getManager(){
        return this.manager;
    }

    public Seller getSeller(){
        return this.seller;
    }

    private static JPanel mainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "login");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "register");
            }
        });

        panel.add(loginButton);
        panel.add(registerButton);

        return panel;
    }

    private JPanel registerUser() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel idLabel = new JLabel("Employee ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel startDateLabel = new JLabel("Start Date:");
        JTextField startDateField = new JTextField();
        JLabel positionLabel = new JLabel("Position:");
        JTextField positionField = new JTextField();
        JLabel buttonLabel = new JLabel("");
        JButton registerButtonPanel3 = new JButton("Register");

        registerButtonPanel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tmpID = Integer.parseInt(idField.getText());
                    String tmpName = nameField.getText();
                    String tmpPassword = new String(passwordField.getPassword());
                    String tmpEmail = emailField.getText();
                    String tmpStartDate = startDateField.getText();
                    String tmpPosition = positionField.getText();
                    Register.registerEmployee(tmpID, tmpName, tmpPassword, tmpEmail, tmpStartDate, tmpPosition);
                    JOptionPane.showMessageDialog(frame, "Register button clicked in register panel");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid new username format. Please enter a valid integer.");
                    idField.setText(""); // Clear the field
                    nameField.setText("");
                    passwordField.setText("");
                    emailField.setText("");
                    startDateField.setText("");
                    positionField.setText("");
                }
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(startDateLabel);
        panel.add(startDateField);
        panel.add(positionLabel);
        panel.add(positionField);
        panel.add(buttonLabel);
        panel.add(registerButtonPanel3);

        return panel;
    }


    private JPanel loginUser() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel idLabel = new JLabel("Employee ID:");
        JTextField idField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JLabel buttonLabel = new JLabel("");
        JButton loginButtonPanel2 = new JButton("Login");

        loginButtonPanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tmpID = Integer.parseInt(idField.getText());
                    String tmpPassword = new String(passwordField.getPassword());
                    Employee tmpuser = new Employee(tmpID, tmpPassword);
                    LogIn.loginUser(tmpuser);
                    Authenticate.this.manager = LogIn.getManager(tmpuser);
                    Authenticate.this.seller = LogIn.getSeller(tmpuser);
                    JOptionPane.showMessageDialog(frame, "Login button clicked in login panel");
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid new username format. Please enter a valid integer.");
                    idField.setText("");
                    passwordField.setText("");
                }
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(buttonLabel);
        panel.add(loginButtonPanel2);

        return panel;
    }
}

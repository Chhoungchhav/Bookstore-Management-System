import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OperationManager extends Operation{

    private Manager m1;
    
    public OperationManager(Manager manager){
        this.m1 = manager;
    }

    @Override
    public void runOperation() {
        frame = new JFrame("Manager Operation");

        JPanel panel1 = managerPanel();
        JPanel panel2 = super.addCustomer();
        JPanel panel3 = popularBook();
        JPanel panel4 = regularCustomer();
        JPanel panel5 = checkSalary();

        frame.setLayout(new CardLayout());
        frame.add(panel1, "main");
        frame.add(panel2, "addCustomer");
        frame.add(panel3, "popularBook");
        frame.add(panel4, "regularCustomer");
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

    private static JPanel managerPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton addCustomerButton = new JButton("Add Customer");
        JButton popularBookButton = new JButton("Check Popular Book");
        JButton regularCustomerButton = new JButton("Check Regular Customer");
        JButton checkSalaryButton = new JButton("Check Salary");
        JButton quitButton = new JButton("Quit");


        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "addCustomer");
            }
        });

        popularBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "popularBook");
            }
        });

        regularCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "regularCustomer");
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


        panel.add(addCustomerButton);
        panel.add(popularBookButton);
        panel.add(regularCustomerButton);
        panel.add(checkSalaryButton);
        panel.add(quitButton);

        return panel;
    }

    private JPanel popularBook() {

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Popular Book is " + Book.checkPopularBook());
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

    private JPanel checkSalary() {

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Your Salary is " + m1.getSalary());
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

    private JPanel regularCustomer() {

        JPanel panel = new JPanel();
        JLabel label = new JLabel("The regular customer is " + Customer.checkRegularCustomer());
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

}

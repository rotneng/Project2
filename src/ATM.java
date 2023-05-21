import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM {
    private static final int PIN = 1234;  // Sample PIN for demonstration purposes only
    private static double balance = 100000; // Initial account balance

    private JFrame frame;
    private JTextField pinField;
    private JLabel messageLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ATM().createAndShowGUI();
            }
        });
    }
      public void createAndShowGUI() {
        frame = new JFrame("ATM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Welcome to the ATM!");
        panel.add(titleLabel);

        JLabel pinLabel = new JLabel("Enter your PIN:");
        panel.add(pinLabel);

        pinField = new JTextField();
        panel.add(pinField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
          
        panel.add(loginButton);

        messageLabel = new JLabel();
        panel.add(messageLabel);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
       private void login() {
        int pinInput = Integer.parseInt(pinField.getText());

        if (pinInput == PIN) {
            showMenu();
        } else {
            messageLabel.setText("Invalid PIN. Please try again.");
        }
    }

    private void showMenu() {
        frame.getContentPane().removeAll();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JLabel titleLabel = new JLabel("ATM Menu:");
        panel.add(titleLabel);

        JButton balanceButton = new JButton("Check Balance");
        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showBalance();
            }
        });
        panel.add(balanceButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showWithdrawal();
            }
        });
        panel.add(withdrawButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDeposit();
            }
        });
    

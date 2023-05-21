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
         panel.add(depositButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        panel.add(exitButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.revalidate();
    }

    private void showBalance() {
        messageLabel.setText("Your current balance is: $" + balance);
    }

    private void showWithdrawal() {
        frame.getContentPane().removeAll();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Withdraw");
        panel.add(titleLabel);

        JLabel amountLabel = new JLabel("Enter the amount to withdraw:");
        panel.add(amountLabel);

        JTextField amountField = new JTextField();
        panel.add(amountField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double withdrawAmount = Double.parseDouble(amountField.getText());
                withdraw(withdrawAmount);
            }
        });
        panel.add(withdrawButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.revalidate();
    }

    private void withdraw(double amount) {
        if (amount > balance) {
            messageLabel.setText("Insufficient funds. Withdrawal canceled.");
        } else {
            balance -= amount;
            messageLabel.setText("Withdrawal successful. Current balance: $" + balance);
        }
    }
    
        
        

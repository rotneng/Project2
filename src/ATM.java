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
    

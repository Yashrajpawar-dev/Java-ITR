import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ATMAppSwing {

    static class User {
        int cardNumber;
        int pin;
        int balance;

        User(int cardNumber, int pin, int balance) {
            this.cardNumber = cardNumber;
            this.pin = pin;
            this.balance = balance;
        }
    }

    private static User[] users = {
        new User(3456, 5678, 100),
        new User(1234, 4321, 5000),
        new User(9999, 1111, 750)
    };

    private static User currentUser;
    private static JFrame frame = new JFrame("VisionBank ATM");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> showCardEntry());
    }

    private static void showCardEntry() {
        frame.getContentPane().removeAll();
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(30, 30, 60));

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBackground(new Color(30, 30, 60));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel label = new JLabel("Enter last 4 digits of card:", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        JTextField input = new JTextField();
        JButton proceed = new JButton("Proceed");

        proceed.addActionListener(e -> {
            try {
                int card = Integer.parseInt(input.getText());
                for (User user : users) {
                    if (user.cardNumber == card) {
                        currentUser = user;
                        showMainMenu();
                        return;
                    }
                }
                showMessage("Invalid card number");
            } catch (NumberFormatException ex) {
                showMessage("Please enter a valid number");
            }
        });

        panel.add(label);
        panel.add(input);
        panel.add(proceed);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static boolean verifyPin() {
        String pinInput = JOptionPane.showInputDialog(frame, "Enter your 4-digit PIN:");
        try {
            int pin = Integer.parseInt(pinInput);
            return pin == currentUser.pin;
        } catch (Exception e) {
            showMessage("Invalid PIN input");
            return false;
        }
    }

    private static void showMainMenu() {
        frame.getContentPane().removeAll();
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(20, 40, 70));

        JLabel welcomeLabel = new JLabel("Welcome to VisionBank ATM", SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(welcomeLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBackground(new Color(20, 40, 70));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        String[] buttons = {"Deposit", "Withdraw", "Check Balance", "Bank Enquiry", "Apply for Checkbook", "Change ATM Pin"};
        JButton[] btnArray = new JButton[buttons.length];

        for (int i = 0; i < buttons.length; i++) {
            btnArray[i] = new JButton(buttons[i]);
            btnArray[i].setBackground(new Color(70, 130, 180));
            btnArray[i].setForeground(Color.WHITE);
            btnArray[i].setFocusPainted(false);
            panel.add(btnArray[i]);
        }

        btnArray[0].addActionListener(e -> {
            if (verifyPin()) performDeposit();
        });
        btnArray[1].addActionListener(e -> {
            if (verifyPin()) performWithdraw();
        });
        btnArray[2].addActionListener(e -> {
            if (verifyPin()) showMessage("Your balance is: ₹" + currentUser.balance);
        });
        btnArray[3].addActionListener(e -> {
            if (verifyPin()) showEnquiry();
        });
        btnArray[4].addActionListener(e -> {
            if (verifyPin()) showMessage("Your application has been submitted.");
        });
        btnArray[5].addActionListener(e -> {
            if (verifyPin()) changePin();
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private static void performDeposit() {
        String input = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
        try {
            int amount = Integer.parseInt(input);
            currentUser.balance += amount;
            saveReceipt("Deposit", amount, currentUser.balance);
            showMessage("Amount deposited. New balance: ₹" + currentUser.balance);
        } catch (Exception e) {
            showMessage("Invalid amount");
        }
    }

    private static void performWithdraw() {
        String input = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
        try {
            int amount = Integer.parseInt(input);
            if (amount > currentUser.balance) {
                showMessage("Insufficient Balance");
            } else {
                currentUser.balance -= amount;
                saveReceipt("Withdrawal", amount, currentUser.balance);
                showMessage("Withdrawal successful. Remaining balance: ₹" + currentUser.balance);
            }
        } catch (Exception e) {
            showMessage("Invalid amount");
        }
    }         
    private static void changePin() {
        String oldPinStr = JOptionPane.showInputDialog(frame, "Enter your old PIN:");
        try {
            int oldPin = Integer.parseInt(oldPinStr);
            if (oldPin == currentUser.pin) {
                String newPinStr = JOptionPane.showInputDialog(frame, "Enter your new PIN:");
                currentUser.pin = Integer.parseInt(newPinStr);
                showMessage("PIN changed successfully.");
            } else {
                showMessage("Incorrect old PIN.");
            }
        } catch (Exception e) {
            showMessage("Invalid PIN");
        }
    }

    private static void showEnquiry() {
        String info = "Bank Name: VisionBank\n"
                + "Customer Name: Mr. Yashraj Pawar\n"
                + "Account Type: Savings Plus Account\n"
                + "Account Number: XXXX-XXXX-" + currentUser.cardNumber + "\n"
                + "Branch: Lohegaon, Pune";
        showMessage(info);
    }

    private static void saveReceipt(String type, int amount, int balance) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "receipt_" + currentUser.cardNumber + "_" + timestamp + ".txt";

            FileWriter writer = new FileWriter(fileName);
            writer.write("VisionBank – Transaction Receipt\n");
            writer.write("-----------------------------------\n");
            writer.write("Card Number: XXXX-XXXX-" + currentUser.cardNumber + "\n");
            writer.write("Transaction Type: " + type + "\n");
            writer.write("Amount: ₹" + amount + "\n");
            writer.write("Balance After Transaction: ₹" + balance + "\n");
            writer.write("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n");
            writer.write("-----------------------------------\n");
            writer.write("Thank you for banking with VisionBank.\n");
            writer.close();
            showMessage("Receipt saved as: " + fileName);
        } catch (IOException e) {
            showMessage("Could not save receipt.");
        }
    }

    private static void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
}

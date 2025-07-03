
    import java.util.*;

class User {
    int cardNumber;
    int pin;
    int balance;

    User(int cardNumber, int pin, int balance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }
}

public class EnhancedATM{
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);

        User[] users = {
            new User(3456, 5678, 100),
            new User(1234, 1111, 2000),
            new User(9876, 2222, 500)
        };

        System.out.println("====Welcome to the ATM machine===");
        System.out.println("Please insert ATM card!");

        System.out.print("Enter the last four digit of card:  ");
        int atmNo = S.nextInt();

        User currentUser = null;
        for (User u : users) {
            if (u.cardNumber == atmNo) {
                currentUser = u;
                break;
            }
        }

        if (currentUser != null) {
            System.out.println("Choose any option by pressing the number");
            System.out.println("1.deposit\n2.Withdraw\n3.check balance\n4.Bank enquiry\n5.Checkbook apply application\n6.Change ATM Pin");
            int choice = S.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Your 4 Digit Pin:  ");
                    int pins = S.nextInt();
                    if (pins == currentUser.pin) {
                        System.out.print("Enter the amount to deposit: ");
                        int depositedAmount = S.nextInt();
                        currentUser.balance += depositedAmount;
                        System.out.println("Your Account balance is: " + currentUser.balance);
                    } else {
                        System.out.println("Invalid Credentials");
                    }
                    break;

                case 2:
                    System.out.print("Enter Your 4 Digit Pin: ");
                    int pin = S.nextInt();
                    if (pin == currentUser.pin) {
                        System.out.print("Enter the amount to Withdraw: ");
                        int amountToWithdraw = S.nextInt();
                        if (amountToWithdraw > currentUser.balance) {
                            System.out.println("Insufficient Balance");
                        } else {
                            currentUser.balance -= amountToWithdraw;
                            System.out.println("Your Remaining Account balance is: " + currentUser.balance);
                        }
                    } else {
                        System.out.println("Invalid Credentials");
                    }
                    break;

                case 3:
                    System.out.print("Enter Your 4 Digit Pin: ");
                    int pin3 = S.nextInt();
                    if (pin3 == currentUser.pin) {
                        System.out.println("Your Account balance is: " + currentUser.balance);
                    } else {
                        System.out.println("Invalid Credentials");
                    }
                    break;

                case 4:
                    String summary =
                        "VisionBank – Your Future, Our Focus\n\n" +
                        "Account Summary – June 2025\n" +
                        "Customer Card Number: XXXX-XXXX-" + currentUser.cardNumber + "\n" +
                        "Account Type: Savings Account\n" +
                        "Branch: Lohegaon, Pune\n\n" +
                        "Account Overview:\n" +
                        "Date       | Description             | Debit (Rs) | Credit (Rs) | Balance (Rs)\n" +
                        "-----------|--------------------------|------------|-------------|--------------\n" +
                        "01-Jun-25  | Salary Credit            |            | 5000.00     | " + (currentUser.balance + 5000) + "\n" +
                        "03-Jun-25  | Grocery Payment          | 450.00     |             | " + (currentUser.balance + 4550) + "\n" +
                        "05-Jun-25  | ATM Withdrawal           | 1000.00    |             | " + (currentUser.balance + 3550) + "\n" +
                        "08-Jun-25  | NEFT Transfer            | 1500.00    |             | " + (currentUser.balance + 2050) + "\n" +
                        "10-Jun-25  | Cashback Credit          |            | 100.00      | " + (currentUser.balance + 2150) + "\n\n" +
                        "Highlights This Month:\n" +
                        "- No maintenance charges.\n" +
                        "- Rs.100 Cashback earned.\n" +
                        "- Auto-transfers active.\n" +
                        "- Secure transactions enabled.\n\n" +
                        "For more details visit: www.visionbank.in";

                    System.out.println(summary);
                    break;

                case 5:
                    System.out.println("Your Application for Checkbook has been submitted");
                    break;

                case 6:
                    System.out.print("Enter your old password:  ");
                    int oldpass = S.nextInt();
                    if (oldpass == currentUser.pin) {
                        System.out.print("Enter the new pass: ");
                        int newpass = S.nextInt();
                        currentUser.pin = newpass;
                        System.out.println("Your password has been Successfully changed");
                    } else {
                        System.out.println("Invalid Old Pin");
                    }
                    break;

                default:
                    System.out.println("Invalid Option");
                    break;
            }
        } else {
            System.out.println("Invalid card details");
        }

        S.close();
    }
}


// in memory
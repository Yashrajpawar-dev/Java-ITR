import java.util.*;

class BankApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance =500;
        System.out.println("Welcome to the Bank Application");

        System.out.println("Enter the account holder name:");
        String accountHolderName = sc.nextLine();
        System.out.println("Account no:");
        String accountNo = sc.nextLine();
               System.out.println("1.deposit");
               System.out.println("2.Withdraw");
               System.out.println("3.check balance");
               int choice = sc.nextInt();

               switch (choice) {
                case 1:
                System.out.println("Enter the amount to deposit:");
                int depositedAmount = sc.nextInt();
                balance +=  depositedAmount;
                    System.out.println("Your amount is deposited successfully,balance is:"+ balance);
                    break;
               case 2:
                    System.out.println("Enter the amount to withdraw: ");
                    int withDrawAmount = sc.nextInt();
                    balance -= withDrawAmount;
                    System.out.println("Your amount is withdrawn successfully, balance is :"+ balance);
                    break;
                case 3:
                    System.out.println("your balance is:");
                    System.out.println(balance);
                    break;
                default:
                System.out.println("Enter a valid choice");
                    break;
               }
               






        
    }
}
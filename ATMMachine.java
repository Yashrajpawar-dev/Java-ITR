import java.util.*;

public class ATMMachine {
    public static void main(String[] args) {
          Scanner S = new Scanner(System.in);
       int user = 3456;
       int pass = 5678;
       int defaultBalance = 100;
       System.out.println("====Welcome to the ATM machine===");
       System.out.println("Please insert ATM card!");

     System.out.print("Enter the last four digit of card:  ");
int atmNo = S.nextInt();
if(atmNo == user){






    

System.out.println("Choose any option by pressing the number");
System.out.println("1.deposit\n2.Withdraw\n3.check balance\n4.Bank enquiry\n5.Checkbook apply application\n6.Change ATM Pin");
int choice = S.nextInt();

switch (choice) {
    case 1:
      System.out.print("Enter Your 4 Digit Pin:  ");
       int pins = S.nextInt();
       if (pins == pass) {
        
       
        System.out.print("Enter the amount to deposit: ");
        int depositedAmount = S.nextInt();
        defaultBalance += depositedAmount;
        System.out.println("Your Account balance is: "+ defaultBalance );
        break;
       }else {
        System.out.println("Invalid Credentials");
        break;
       }
        case 2:
        System.out.print("Enter Your 4 Digit Pin: ");
         int pin = S.nextInt();
         if (pin == pass) {
            
         
        System.out.print("Enter the amount to Withdraw: ");
        int AmounttoWithdraw = S.nextInt();
        if(AmounttoWithdraw > defaultBalance){
            System.out.println("Insufficient Balance");
        }else{
            defaultBalance -= AmounttoWithdraw;
        System.out.println("Your Remaining Account balance is: "+ defaultBalance );
        }
        break;
    }
    else{
        System.out.println("Invalid Credentials");
       break;
    }
         case 3:
        System.out.print("Enter Your 4 Digit Pin: ");
        int pin3 = S.nextInt();
        if(pin3 == pass){
        System.out.println("Your Account balance is: "+ defaultBalance );
        break;
        }else {
            System.out.println("Invalid Credentials");
       break;
        }
        case 4:
       String summary = 
            "🏦 VisionBank – Your Future, Our Focus\n\n" +
            "Account Summary – June 2025\n" +
            "Customer Name: Mr. Yashraj Pawar\n" +
            "Account Type: Savings Plus Account\n" +
            "Account Number: XXXX-XXXX-1234\n" +
            "Branch: Lohegaon, Pune\n\n" +

            "💰 Account Overview:\n" +
            "Date       | Description             | Debit (₹) | Credit (₹) | Balance (₹)\n" +
            "-----------|--------------------------|-----------|------------|-------------\n" +
            "01-Jun-25  | Salary Credit - Microsoft|           | 75,000.00  | 1,25,000.00\n" +
            "03-Jun-25  | UPI Payment – Swiggy     | 550.00    |            | 1,24,450.00\n" +
            "05-Jun-25  | ATM Withdrawal           | 10,000.00 |            | 1,14,450.00\n" +
            "08-Jun-25  | NEFT – Mutual Fund SIP   | 5,000.00  |            | 1,09,450.00\n" +
            "10-Jun-25  | Cashback – UPI Offer     |           | 250.00     | 1,09,700.00\n\n" +

            "🌟 Highlights This Month:\n" +
            "- ✅ Zero balance fee maintained.\n" +
            "- 💸 ₹250 Cashback earned from UPI transactions.\n" +
            "- 📈 Auto-investments helping your savings grow steadily.\n" +
            "- 🔒 100% Safe & Secure Transactions backed by VisionProtect™.\n\n" +

            "🔔 Upgrade to VisionBank Premium\n" +
            "Enjoy free international transfers, higher interest rates, and personalized wealth advice.\n\n" +
            "📱 Download the VisionBank App\n" +
            "Or visit us at www.visionbank.in";

        System.out.println(summary);
        
        break;
case 5:
       
        System.out.println("Your Application for Checkbook has been submitted");
        break;
        case 6:
       
        System.out.print("Enter you old password:  ");
        int oldpass = S.nextInt();
        if(oldpass == pass){
            System.out.print("Enter the new pass: ");
            int newpass = S.nextInt();
            newpass = pass;
            System.out.println("Your password has been Successfully changed");
        }else {
            System.out.println("Invalid Old Pin");
        }
        break;
    default:
        break;
    }
}else{
    System.out.println("Invalid card details");




}
 S.close();
    }
  
    
}

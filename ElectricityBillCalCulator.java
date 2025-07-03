import java.util.*;
 
class billDetails{
   int unitsConsumed;
   String CustomerName;
    int custmerId;
     double amount = 0;
     float surcharge;
   void billDetails(Scanner s){


   

        System.out.print("Enter the customer name: ");
       CustomerName = s.nextLine();
        System.out.print("Enter the custmer Id: ");
       custmerId = s.nextInt();
        System.out.print("Enter units consumed: ");
 unitsConsumed = s.nextInt();
    }
    void calculation(){
 
 
  if(unitsConsumed <=100){
    amount = unitsConsumed * 1.5;
surcharge = 0; 
  }else if (unitsConsumed <= 250){
    amount = unitsConsumed * 2.5;
     surcharge = (float)(amount * 0.10);
  }else{
    amount = unitsConsumed * 6;
    surcharge = (float)(amount * 0.10);

  }
  
}
void bill( ){
 System.out.println("\nElectricity Bill Summary ");
        System.out.println("Customer Name: " + CustomerName);
        System.out.println("Customer ID: " + custmerId);
        System.out.println("Base Charge: " + amount);
        System.out.println("Surcharge "+ surcharge);
        System.out.println("Total Bill: ₹" + amount + surcharge);
    }
void again(Scanner s){
    s.nextLine();
    System.out.println("Do you want calculate again(yes/no)");
    String tas = s.nextLine();
    switch (tas) {
        case "yes":
        billDetails t = new billDetails();
           t.billDetails(s);
t.calculation();
t.bill();
t.again(s);
            break;
            case "y":
        billDetails g = new billDetails();
           g.billDetails(s);
g.calculation();
g.bill();
g.again(s);
            break;
    case "no":
    System.out.println("Thankyou for using our electricity bill Calculator");
    s.close();
    break;
        default:
        System.out.println("Enter valid statement!");
        
            break;
    }
}
} public class ElectricityBillCalCulator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       
billDetails t = new billDetails();
t.billDetails(s);
t.calculation();
t.bill();

t.again(s);
        }
}


  


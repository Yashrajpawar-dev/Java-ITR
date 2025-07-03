import java.util.*;

class Order extends Thread{
 int StockName1;
 int qty;
 double price;
    void Order(int t, int q,double p){

        this.StockName1 = t;
        this.qty = q;
        this.price = p;










    }
}

public class OrderMatchingSystem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        float price[] = {111.65f, 1267.55f, 34532.78f, 587.78f,3244.347f};
       String StockName[] ={"1.AAPL","2.BHEL","3.IRFC","4.BPCL","5.HPCL"};
       
        System.out.println("=====Stock Market Order Matching System=====");
        System.out.print("Enter Type Buy/Sell: ");
        String TypeOrder = s.nextLine();
        System.out.println("Stock list");
        for(int i =0;i<=StockName.length-1;i++){
            System.out.println(StockName[i]);
           
        }
        System.out.println("Choose a stock:(1-5): ");
        int Choosed = s.nextInt();
        System.out.print("Enter the quantity: ");
        int qua = s.nextInt();
        System.out.println("Order Placed sucessfully");
        System.out.println( qua +"@"+ price[Choosed]);
        double amount = qua*price[Choosed];
        System.out.println("total amount "+amount);
Order o = new Order(StockName[i],int qua,double amount);


        
        }

    }

    

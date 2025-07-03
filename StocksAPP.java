import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Order {
    String type;
    int stockIndex;
    int qty;
    double price;
    LocalDateTime time;

    Order(String type, int stockIndex, int qty, double price) {
        this.type = type;
        this.stockIndex = stockIndex;
        this.qty = qty;
        this.price = price;
        this.time = LocalDateTime.now();
    }
    Order(String type, int stockIndex, double price) {
        this(type, stockIndex, 1, price);
    }
void printOrder(String[] stockNames) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("\nOrder Details:");
        System.out.println("Type: " + type.toUpperCase());
        System.out.println("Stock: " + stockNames[stockIndex]);
        System.out.println("Quantity: " + qty);
        System.out.printf("Price per unit: ₹%.2f\n", price);
        System.out.printf("Total amount: ₹%.2f\n", qty * price);
        System.out.println("Time: " + time.format(format));
    }
}
public class StocksAPP{
                public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] stockNames = {"AAPL", "BHEL", "IRFC", "BPCL", "HPCL"};
        double[] basePrices = {111.65, 1267.55, 34532.78, 587.78, 3244.35};
        System.out.println("===== Stock Market Order Matching System =====");
        System.out.print("Enter Order Type (Buy/Sell): ");
        String type = s.nextLine().toLowerCase();
        System.out.println("Available Stocks:");
        for (int i = 0; i < stockNames.length; i++) {
            System.out.printf("%d. %s (Base ₹%.2f)\n", i + 1, stockNames[i], basePrices[i]);
        }
        System.out.print("Choose a stock (1-5): ");
        int index = s.nextInt() - 1;
        System.out.print("Enter Quantity: ");
        int qty = s.nextInt();    
        Random rand = new Random();
        double fluctuation = (rand.nextDouble() * 0.2 - 0.1); 
        double fluctuatedPrice = basePrices[index] * (1 + fluctuation);
        Order order = new Order(type, index, qty, fluctuatedPrice);
        System.out.println("\nOrder Placed Successfully!");
        order.printOrder(stockNames);
    }
}



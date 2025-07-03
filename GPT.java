import java.util.*;

class Direction {
    String name;
    String[] vehicles;

    Direction(String name, String[] vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    void signal() throws InterruptedException {
        System.out.println(name + ": RED");
        Thread.sleep(10000);

        System.out.println(name + ": YELLOW");
        Thread.sleep(10000);

        System.out.print(name + ": GREEN - ");
        for (String v : vehicles) {
            System.out.print(v + " ");
        }
        System.out.println();
        Thread.sleep(10000);
    }
}

public class GPT {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String[] common = {"Bus", "Car", "Truck"};
        String[] emergency = {"Ambulance"};

        Direction north = new Direction("North", common);
        Direction south = new Direction("South", common);
        Direction east = new Direction("East", common);
        Direction west = new Direction("West", common);
        Direction emer = new Direction("Emergency", emergency);

        while (true) {
            System.out.print("Any ambulance? (yes/no): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("yes")) {
                System.out.println("All signals RED");
                Thread.sleep(10000);
                emer.signal();
                System.out.println("Ambulance passed.\n");
            } else {
                north.signal();
                south.signal();
                east.signal();
                west.signal();
            }
        }

        // sc.close(); // Don’t close Scanner in infinite loop
    }
}
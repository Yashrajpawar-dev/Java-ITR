import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingLotSystem {
    public LocalDateTime entryTime;
    Map<String, LocalDateTime> vehicleRecords = new HashMap<>();

    void vehicleEntry(Scanner s) {
        s.nextLine();

        System.out.print("Enter Vehicle number: ");
        String number = s.nextLine();

        System.out.print("Enter the type of vehicle(2 or 4): ");
        int vehicleType = s.nextInt();

        if (vehicleType == 2) {
            System.out.println("Charges:");
            System.out.println("From 30 mins to 1:30min @ 60Rs");
            System.out.println("From 1:30 mins to 3:00min @ 80Rs");
            System.out.println("24 hours @ 120 rs");
        } else if (vehicleType == 4) {
            System.out.println("Charges:");
            System.out.println("From 30 mins to 1:30min @ 100Rs");
            System.out.println("From 1:30 mins to 3:00min @ 150Rs");
            System.out.println("24 hours @ 220 rs");
        } else {
            System.out.println("Enter a valid choice!");
            return;
        }

        entryTime = LocalDateTime.now();
        vehicleRecords.put(number, entryTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Entry time: " + entryTime.format(formatter));
        System.out.println("Vehicle Added Successfully!");
    }

    void vehicleExit(Scanner s) {
        s.nextLine();

        System.out.println("Enter Vehicle number: ");
        String number = s.nextLine();

        if (vehicleRecords.containsKey(number)) {
            LocalDateTime exitTime = LocalDateTime.now();
            LocalDateTime entry = vehicleRecords.get(number);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            System.out.println("Entry time was: " + entry.format(formatter));
            System.out.println("Exit time is: " + exitTime.format(formatter));
            vehicleRecords.remove(number);
        } else {
            System.out.println("Vehicle not found!");
        }
    }

    public static void main(String[] args) {
        new FirstClass(); 
    }
}

class FirstClass {
    FirstClass() {
        Scanner s = new Scanner(System.in);
        ParkingLotSystem obj = new ParkingLotSystem();

        while (true) {
            System.out.println("\n--- Welcome to the Venture Parking Lot ---");
            System.out.println("1. Vehicle Entry");
            System.out.println("2. Vehicle Exit");
            System.out.println("3. Exit System");

            int answer = s.nextInt();

            switch (answer) {
                case 1:
                    obj.vehicleEntry(s);
                    break;
                case 2:
                    obj.vehicleExit(s);
                    break;
                case 3:
                    System.out.println("Thank you for using the system!");
                    s.close();
                    return;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }
}

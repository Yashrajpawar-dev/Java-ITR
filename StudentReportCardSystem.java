
import java.io.*;
import java.util.Scanner;
class Employee implements Serializable {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

public class StudentReportCardSystem   {


   public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

 String filename = "students.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
           
                String[] data = line.split("\\s+");

                String name = data[0];
                int rollNo = Integer.parseInt(data[1]);
                int mark1 = Integer.parseInt(data[2]);
                int mark2 = Integer.parseInt(data[3]);
                int mark3 = Integer.parseInt(data[4]);  
                System.out.println("Name: " + name);
                System.out.println("Roll No: " + rollNo);
                System.out.println("Marks: " + mark1 + ", " + mark2 + ", " + mark3);
                System.out.println("------------------------------");

   } 
}
 catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
}}}}
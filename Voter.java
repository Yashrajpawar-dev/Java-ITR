 import java.util.*;

public class Voter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of voter:");
        String nameOfVariable = sc.nextLine();
        System.out.println("Enter the age:");
        int age = sc.nextInt();
        if (age<18){
            System.out.println("Your are not eligible for voting");

             
               }

        else{
            System.out.println("you are eligible");
System.out.println("1.BJP");
               System.out.println("2.Maharashtra navnirman sena");
               System.out.println("3.Shivsena");
               System.out.println("4.Congress");
  int choice = sc.nextInt();
              System.out.println("your vote has been submitted");
        }
    }}
    


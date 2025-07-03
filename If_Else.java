import java.util.*;


public class If_Else {
  public static void main(String[] args) {
    int B1 = 1, B2 = 2, B3 = 3;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the digit to print a message: ");
     int B = sc.nextInt();
    if(B1 == B){
     System.out.println("Hello");
    }else if (B == B2) {
        System.out.println("Hi");
    }else{
        System.out.println("Bye");
    }
  }  
}


import java.util.*;

public class Marksheet {
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
        System.out.println("Enter the name of student: ");
        String name = s.nextLine();
        System.out.println("Enter the marks for 5 subjects");
        System.out.println("Enter the marks for English: ");
        int eng = s.nextInt();
        System.out.println("Enter the marks for Maths: ");
        int math = s.nextInt();
        System.out.println("Enter the marks for Marathi: ");
        int marathi = s.nextInt();
        System.out.println("Enter the marks for Science: ");
        int sci = s.nextInt();
        System.out.println("Enter the marks for Hindi: ");
        int hindi = s.nextInt();

double percentage;
float total = (eng + math+ marathi + sci+hindi);
percentage = ((total/500) * 100);
if(percentage > 90){
    System.out.println("The percentage are " + percentage + " A+ grade");
}else if(percentage > 80){
    System.out.println("The percentage are " + percentage + " A grade");
}else if(percentage > 70){
    System.out.println("The percentage are " + percentage + " B grade");
}else if(percentage > 60){
    System.out.println("The percentage are " + percentage + " C grade");
}else if(percentage > 50){
    System.out.println("The percentage are " + percentage + " D grade");
}else if (percentage > 40){
    System.out.println("The percentage are " + percentage + " F grade");
}else{
    System.out.println("The percentage are " + percentage + " Fail");
}
s.close();
    }
}

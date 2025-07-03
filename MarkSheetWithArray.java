import java.util.*;

public class MarkSheetWithArray{    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int marks[] = new int[5];
       String sub[] = {"English", "Marathi", "Maths", "Science", "Computer"};
float sum= 0;

System.out.println("=======Welcome to Percentage Calculator=======");
System.out.print("Enter your name: ");
String name = s.nextLine();
System.out.print("Enter Your Roll No: ");
int rollNo = s.nextInt();
       for(int i=0;i<5;i++){
        System.out.print("Enter the marks for " + sub[i]+ ": "   );
         marks[i] = s.nextInt();

       }
      
      
      
    for(int i=0;i<5;i++){  
        sum += marks[i] ;
    }
       

float percentage = ((sum /500)*100);





       



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
}else if (percentage > 35){
    System.out.println("The percentage are " + percentage + " F grade");
}else{
    System.out.println("The percentage are " + percentage + " Fail");
}
s.close();
    }
}



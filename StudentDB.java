


import java.util.*;
import java.io.*;
class StudentDB{
void addStudent(Scanner s,String name, int rollno, String grade){

try{
    File f = new File("File-Yash.txt");
if(f.createNewFile()){
    System.out.println("File has been created successfully!");
}else{
    System.out.println("File already exists");
    FileWriter y = new FileWriter(f , true);
    y.write("Name of the student: "+ name+"\n");
    y.write("Roll no of the student: "+ rollno+"\n");
    y.write("Grade of the student: "+ grade+"\n");
     y.close() ;
}
}
    catch(Exception e) {
            System.out.println("An error occurred while adding student details.");
        }


}
   
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
 String  Students[] = new String[50];
        int RollNo[] = new int[50];
        String Grade [] = new String[50];
        System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();

StudentDB db = new StudentDB();
switch (choice) {
    case 1:
            System.out.println("Enter the name of the student: ");
            s.nextLine();
            
        String name = s.nextLine();
        System.out.println("Enter Roll No of the student: ");
        int rollno = s.nextInt();
        System.out.println("Enter the Grade: ");
        s.nextLine();
        String grade = s.nextLine();

  
        db.addStudent(s,name,rollno,grade);

        break;

    default:
        break;
}
}} 
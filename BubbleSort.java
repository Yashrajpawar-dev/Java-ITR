import java.util.*;



public class BubbleSort {


public static void exeSearch(int array[]){
for(int i = 0;i<array.length-1;i++){
    for(int j = 1;j<array.length-1-i;j++){
       if(array[j]>array[i]){
         int temp = array[j];
         array[j] =  array[i];
        array[i] = temp;
       }
    
    }
}
for(int i=0;i<array.length;i++){
    System.out.println(array[i]);
}
}
  public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
         System.out.print("Enter the no of elements you need: \n");
   int n = s.nextInt();
    int[] array = new int[n];
    
    System.out.print("Enter the sorted values in the array: \n");
    for(int i=0;i<array.length;i++){
array[i] = s.nextInt();


    }exeSearch( array);
    }
}

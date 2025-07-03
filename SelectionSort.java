import java.util.Scanner;

public class SelectionSort {


    public static void exeSearch(int[] array){
 for(int i=0 ; i<array.length;i++){
    int max= 0;
    int last = array.length - i -1;
max = maxNum(array,last,max);

 }
  
 
}
   public static int maxNum(int[] array, int last,int max){
    for(int i = 0 ; i<=last;i++){
        
     if(array[i] > array[max]){
    max = i;
}
        
    }
int temp = array[last];
array[last] = array[max];
array[max] = temp;
return max;

    
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
      System.out.println("Sorted array:");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}

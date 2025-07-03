import java.util.*;


public class BinarySearch {
    
 public static void  exactSearch(int array[], int lower, int high,int key) {
    while(lower <= high){
      int mid = (lower + high)/2;
      if(array[mid]==key){
System.out.println("Element found at index: "+ mid);
return;
      }  else if(array[mid]<key) {
lower = mid +1;
      }else {
    high = mid-1;
      }
        
      }
   
System.out.println("element not found");
}

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
   System.out.print("Enter the no of elements you need: \n");
   int n = s.nextInt();
    int[] array = new int[n];
    
    System.out.print("Enter the sorted values in the array: \n");
    for(int i=0;i<array.length;i++){
array[i] = s.nextInt();
    }

    System.out.print("Enter the key element to search: \n");
    int key = s.nextInt();

    int lower = 0;
    int high = array.length-1;
   
    exactSearch(array,lower,high,key);

    }
}

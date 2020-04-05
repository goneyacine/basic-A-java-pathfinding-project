package Systems;
import java.util.List;
public class bubbleSort {
    public static void Sort(List<Float> arr){
     boolean isSorted = false;
     int n = arr.size();
     //check if the array is sorted or not for the first time
     for(int i = 0 ; i < n - 1;i++){
         if(arr.get(i) > arr.get(i+1)){
             isSorted = false;
             break;
         }else{
             isSorted = true;
         }
     }
     //keep sorting the array until it will be sorted
     while(!isSorted){
         //here is the sorting pass
         for(int i = 0; i < n -1; i++){
             if(arr.get(i) > arr.get(i+1)){
                 float temp = arr.get(i+1);
                 arr.set(i+1, arr.get(i));
                 arr.set(i,temp);
             }
         }
         //check if the array is sorted
         for(int i = 0 ; i < n - 1;i++){
            if(arr.get(i) > arr.get(i + 1)){
                isSorted = false;
                break;
            }else{
                isSorted = true;
            }
        }
     }
     for(float number : arr){
      System.out.print( " "  + number);
     }
    }
}
import java.util.*;
 
public class Increasing_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        long ans = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i]){
                ans = ans + arr[i-1]-arr[i];
                arr[i] = arr[i-1];
            }
        }
        System.out.println(ans);
    }
}

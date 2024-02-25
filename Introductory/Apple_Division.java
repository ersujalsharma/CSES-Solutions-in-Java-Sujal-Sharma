import java.util.*;
 
public class Apple_Division {
    static long ans = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        help(arr,0,0,0);
        System.out.println(ans);
    }
 
    private static void help(int[] arr, int index, long sum1, long sum2) {
        // TODO Auto-generated method stub
        if(index==arr.length){
            // if(sum1!=0 && sum2!=0){
                ans = Math.min(Math.abs(sum1-sum2),ans);
            // }
            return;
        }
        help(arr,index+1,sum1+arr[index],sum2);
        help(arr,index+1,sum1,sum2+arr[index]);
    }
    
}
